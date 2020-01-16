package com.pk.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "EDUCATIONAL_DETAILS")
public class EducationalDetailsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EDU_ID", length = 10)
	private Integer eid;
	
	@Column(name = "HIGHEST_DEGREE",length = 20)
	private String highestDegree;
	
	@Column(name = "UNIVERSITY",length = 20)
	private String university;
	
	@Column(name = "PASSOUT_YEAR",length = 4)
	private Integer passoutYear;
	
	@OneToOne
	@JoinColumn(name = "PERSON_ID")
	private PersonDetailsEntity perDtlsEntity;	
	
	@Column(name = "CREATED_DATE",nullable = false,updatable = false)
	@CreationTimestamp
	private Timestamp createdDate;
	
	@Column(name = "UPDATED_DATE")
	@UpdateTimestamp
	private Timestamp updatedDate;
	
}
