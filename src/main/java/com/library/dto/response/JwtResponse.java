package com.library.dto.response;

import org.springframework.security.core.GrantedAuthority;

import com.library.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private String name;
    private String username;
    private List<String> roles;
//    private Optional<User> user;
//    private Collection<?extends GrantedAuthority> roles;

    

//    public JwtResponse(String token, String name, String username, Optional<User> user, List<String> roles) {
//        this.token = token;
//        this.name = name;
//        this.username = username;
//        this.roles = roles;
//        this.user = user;
//    }
    public JwtResponse(String token, String name, String username, List<String> roles) {
        this.token = token;
        this.name = name;
        this.username = username;
        this.roles = roles;
//        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

//	public JwtResponse(String token2, String name2, String username2, Collection<String> roles2, Optional<User> user2) {
//		// TODO Auto-generated constructor stub
//	}

}

