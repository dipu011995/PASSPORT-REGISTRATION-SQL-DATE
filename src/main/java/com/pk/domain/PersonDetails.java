package com.pk.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class PersonDetails {

	private Integer pid;	
	private String fname;
	private String lname;
	private String email;
	private Date dob;
	private String gender;
	private Long adharNo;
	
}
