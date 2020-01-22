package com.nit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "YEAR_MASTER")
public class YearsEntity {

	@Id
	@Column(name = "YEAR_ID")
	private int YEAR_ID;

	@Column(name = "YEAR")
	private int YEAR;

}
