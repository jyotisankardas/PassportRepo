package com.nit.entity;

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
	private int UNIV_ID;
	@Column(name = "UNIV_NAME")
	private String UNIV_NAME;

}
