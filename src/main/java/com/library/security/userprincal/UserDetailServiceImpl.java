package com.library.security.userprincal;

import com.library.entity.User;
import com.library.repository.UserRepository;
import com.library.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	UserServiceImpl userService;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> 
				new UsernameNotFoundException("User not found with username " + username)
				);
		if (user == null) {
            throw new UsernameNotFoundException(username);
        }
		return UserPrinciple.build(user);
	}

	 
	public User getCurrentUser() {
		Optional<User> user;
		String userName;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		if (userRepository.existsByUsername(userName)) {
			user = userService.findByUsername(userName);
		} else {
			user = Optional.of(new User());
			user.get().setUsername("Anonymous");
		}
		return user.get();
	}
}