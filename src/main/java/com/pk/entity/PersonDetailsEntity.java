package com.pk.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name ="PERSON_DETAILS" )
public class PersonDetailsEntity {

	@Id
	@GeneratedValue
	@Column(name = "PERSON_ID", length = 10)
	private Integer pid;	
	
	@Column(name = "FIRST_NAME",length = 20)
	private String fname;
	
	@Column(name = "LAST_NAME",length = 20)
	private String lname;
	
	@Column(name = "EMAIL",length = 30)
	private String email;
	
	@Column(name = "DOB")
	private Date dob;
	
	@Column(name = "GENDER",length = 1)
	private String gender;
	
	@Column(name = "ADHAR_NO",length = 12)
	private Long adharNo;
	
	@Column(name = "CREATED_DATE",nullable = false,updatable = false)
	@CreationTimestamp
	private Timestamp createdDate;
	
	@Column(name = "UPDATED_DATE")
	@UpdateTimestamp
	private Timestamp updatedDate;

}
