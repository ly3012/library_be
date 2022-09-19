package com.library.entity;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "callSlip")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="idCallSlip")
public class callSlip {
	


	public callSlip(reader reader2, User user2, Set<book> books2) {
		// TODO Auto-generated constructor stub
		this.books = books2;
		this.reader = reader2;
		this.user = user2;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCallSlip")
	private long idCallSlip;
	
	@CreatedDate
	@Column(name = "create_at",nullable = false, updatable = true)
    private Date created;
	
   
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn (name = "id_reader")
	private reader reader;
	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn (name = "id")
	private User user;

	@Column(columnDefinition = "boolean default false")
    private Boolean status = false;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JsonManagedReference
	@JoinTable(
			name = "book_callSlip",
			joinColumns = @JoinColumn (name = "idCallSlip"),
			inverseJoinColumns = @JoinColumn(name = "id_book")
			)	
	private Collection<book> books;
	
	

}
