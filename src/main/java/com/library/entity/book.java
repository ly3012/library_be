package com.library.entity;

import java.time.Instant;
import java.time.LocalDateTime;
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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Books")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
public class book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_book")
	private long idBook; 
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "authors")
	private String author;
	
	@Column(name = "numberOfPages")
	private long numberOfPages;
	
	@Column(name = "released")
	private String released;
	
	@Column(name = "amount")
	private long amount;
	
	@Column(name = "image")
	private String image;
	
	@CreatedDate
	@Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;
	
	@LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
	
//	
//	 @ManyToMany(mappedBy = "book_callSlip")
//	    private Set<callSlip> callSlips;
}
