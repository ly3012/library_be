package com.library.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "admin")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_admin")
	private long idAdmin;
	
	@Column(name = "fullName")
	private String fullName;
	
	@Column(name = "username")
	private String userName;
	
	@Column(name = "password")
	private String passWord;
	
	@Column(name = "phoneNumber")
	private String phoneNumber;
	
	@Column(name = "address")
	private String address;
	
	@LastModifiedDate
	@Column(name = "updated_at",nullable = false, updatable = true)
    private Date updatedAt;
	
	@Column(name = "Status")
	private boolean status;
	
	@Column(name = "role")
	private String role;
	
	
//	@OneToMany (mappedBy = "callSlip")
//	private Set<callSlip> callSlips;
	
}
