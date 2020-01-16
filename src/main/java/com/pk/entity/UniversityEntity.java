package com.pk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "UNIVERSITY_MASTER")
public class UniversityEntity {
	
	@Id
	@Column(name = "UNIV_ID")
	private Integer univId;
	
	@Column(name = "UNIV_NAME")
	private String univName;

}
