package com.library.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "callSlip")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
public class callSlip {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCallSlip")
	private long idCallSlip;
	
	@CreatedDate
	@Column(name = "create_at",nullable = false, updatable = true)
    private Date created;
	
	@ManyToOne
	@JoinColumn (name = "id_reader")
	private reader idReader;
	
	@ManyToMany
	@JoinTable(
			name = "book_callSlip",
			joinColumns = @JoinColumn (name = "id_book"),
			inverseJoinColumns = @JoinColumn(name = "idCallSlip")
			)	
	private List<book> books;
	
	
	@ManyToOne
	@JoinColumn (name = "id_admin")
	private Admin idAdmin;
//	
//	@ManyToOne 
//    @JoinColumn(name = "address_id") // thông qua khóa ngoại address_id
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    private Address address;
//	
	


}
