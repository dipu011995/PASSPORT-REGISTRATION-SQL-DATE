package com.pk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "DEGREE_MASTER")
public class HighestDegreeEntity {
	
	@Id
	@Column(name = "DEGREE_ID")
	private Integer degreeId;
	
	@Column(name = "DEGREE_NAME")
	private String degreeName;

}
