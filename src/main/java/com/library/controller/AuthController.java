package com.library.controller;

import com.library.dto.response.JwtResponse;
import com.library.dto.response.ResponseMessage;
import com.library.dto.request.SignInForm;
import com.library.dto.request.SignUpForm;
import com.library.entity.Role;
import com.library.entity.RoleName;
import com.library.entity.User;
import com.library.security.jwt.JwtProvider;
import com.library.security.userprincal.UserDetailServiceImpl;
import com.library.security.userprincal.UserPrinciple;
import com.library.service.UserService;
import com.library.service.impl.RoleServiceImpl;
import com.library.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/auth")
@RestController
public class AuthController {
	
	@Autowired
	UserService userService;
	@Autowired
	UserServiceImpl userServiceImpl;
	@SuppressWarnings("unused")
	@Autowired
	private UserDetailServiceImpl userDetailsService;
	@Autowired
	RoleServiceImpl roleService;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	JwtProvider jwtProvider;
	@Autowired
	AuthenticationManager authenticationManager;

	@PostMapping("/createUser")
	public ResponseEntity<?> register(@Valid @RequestBody SignUpForm signUpForm) {
		if (userServiceImpl.existsByUsername(signUpForm.getUsername())) {
			return new ResponseEntity<>(new ResponseMessage("tên đăng nhập đã tồn tại"), HttpStatus.OK);
		}
		if (userServiceImpl.existsByEmail(signUpForm.getEmail())) {
			return new ResponseEntity<>(new ResponseMessage("email đã tồn tại"), HttpStatus.OK);
		}

		User user = new User(signUpForm.getName(), signUpForm.getUsername(), signUpForm.getEmail(),
				passwordEncoder.encode(signUpForm.getPassword()), signUpForm.getPhoneNumber());
		Set<String> strRoles = signUpForm.getRoles();
		Set<Role> roles = new HashSet<>();
		strRoles.forEach(role -> {
			switch (role) {
			case "admin","ROLE_ADMIN":
				Role adminRole = roleService.findByName(RoleName.ROLE_ADMIN)
						.orElseThrow(() -> new UsernameNotFoundException("Role Not Found!"));
				roles.add(adminRole);
				break;

			default:
				Role userRole = roleService.findByName(RoleName.ROLE_USER)
						.orElseThrow(() -> new UsernameNotFoundException("Role Not Found!"));
				roles.add(userRole);
			}
		});
		user.setRoles(roles);
		userServiceImpl.save(user);
		
		return ResponseEntity.ok(new ResponseMessage("Tạo tài khoản thành công!"));
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody SignInForm signInForm) {
		
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						signInForm.getUsername(), 
						signInForm.getPassword()
				)
		);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String token = jwtProvider.createToken(authentication);
		UserPrinciple userDetails = (UserPrinciple) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
		UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
		
		Optional<User> user = userService.findByUsername(signInForm.getUsername());
		
		return ResponseEntity.ok(
				new JwtResponse(
						token, 
						userPrinciple.getName(), 
						userPrinciple.getUsername(),
						roles
						
				)
		);
//		return ResponseEntity.ok(
//				new JwtResponse(
//						token, 
//						userPrinciple.getName(), 
//						userPrinciple.getUsername(),
//						user,
//						roles
//						
//				)
//		);

	}

}