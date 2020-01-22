package com.nit.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "Educational_Details")
public class EducationalDetailsEntity {

	@Id
	@GeneratedValue
	@Column(name = "EDU_ID", length = 10)
	private Integer eduId;
	@Column(name = "PASSED_YEAR", length = 5)
	private Integer year;
	@Column(name = "UNIVERSITY", length = 20)
	private String univercity;
	@Column(name = "HIGHEST_DEGREE", length = 20)
	private String highestDegree;
	
	@OneToOne
	@JoinColumn(name="PERSION_ID")
	private PersonEntity entity;
	
	
	@Column(name = "CREATED_DATE", nullable = false, updatable = false)
	@CreationTimestamp
	private Date createdDate;
	@Column(name = "UPDATED_DATE")
	@UpdateTimestamp
	private Date updatedDate;
}
