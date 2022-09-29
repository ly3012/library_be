package com.library.entity;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Books")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="idBook")
public class book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_book")
	private long idBook; 
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "author")
	private String author;
	
	@Column(name = "numberOfPages")
	private long numberOfPages;
	
	@Column(name = "released")
	private String released;
	
	@Column(name = "amount")
	private long amount;
	
	@Column(name = "image")
	private String image;
	
	@LastModifiedDate
	@Column(name = "updated_at", nullable = false, updatable = true)
    private Date updatedAt;
	
	 @ManyToMany(mappedBy = "books",fetch = FetchType.LAZY)
	 @JsonIgnore
	 private Collection<callSlip> callSlips;
	
//	@LastModifiedDate
//    @Column(name = "updated_at")
//    private LocalDateTime updatedAt;
	
}
