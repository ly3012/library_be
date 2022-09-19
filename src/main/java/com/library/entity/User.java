package com.library.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user", uniqueConstraints = { @UniqueConstraint(columnNames = { "username" }),
		@UniqueConstraint(columnNames = { "email" }) })

@NoArgsConstructor
@AllArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(min = 3, max = 50)
	private String name;
	
	@NotBlank
	@Size(min = 3, max = 50)
	private String username;
	
	@NaturalId
	@NotBlank
	@Size(max = 50)
	@Email
	private String email;
	
	@JsonIgnore
	@NotBlank
	@Size(min = 6, max = 100)
	private String password;
	
	@Lob
	private String avatar;
	
	@NotBlank
	@Column(name = "phoneNumber")
	private String phoneNumber;
	
	@LastModifiedDate
	@Column(name = "updated_at",nullable = false, updatable = true)
    private Date updatedAt;
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "users_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
	
	

	    public User(Long id, String name, String username, String email, String password, String avatar, String phoneNumber, Set<Role> roles) {
	        this.id = id;
	        this.name = name;
	        this.username = username;
	        this.email = email;
	        this.password = password;
	        this.avatar = avatar;
	        this.roles = roles;
	    }

	    public User(  @NotBlank @Size(min = 3,max = 50) String name,
	                  @NotBlank @Size(min = 3,max = 50)String username,
	                  @NotBlank @Size(max = 50) @Email String email,
	                  @NotBlank @Size(min = 6,max = 100) String password,
	                  @NotBlank @Size(min = 9, max = 12) String phoneNumber) {
	        this.name = name;
	        this.username = username;
	        this.email = email;
	        this.password = password;
	        this.phoneNumber = phoneNumber;
	    }

}
