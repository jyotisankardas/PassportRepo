package com.nit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "DEGREES_MASTER")
public class DegreeEntity {

	@Id
	@Column(name = "DEGREE_ID")
	private int DEGREE_ID;

	@Column(name = "DEGREE_NAME")
	private String DEGREE_NAME;

}
