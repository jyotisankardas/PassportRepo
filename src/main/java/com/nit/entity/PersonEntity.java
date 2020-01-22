package com.nit.entity;

import java.util.Date;

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
@Table(name = "passportdetails_info")
public class PersonEntity {
	@Id
	@Column(name = "PERSION_ID", length = 10)
	@GeneratedValue
	private Integer personId;
	@Column(name = "Fname", length = 20)
	private String firstName;
	@Column(name = "Lname", length = 10)
	private String lastName;
	@Column(name = "email", length = 30)
	private String email;
	@Column(name = "dob", length = 15)
	private Date dob;
	@Column(name = "gender", length = 7)
	private char gender;
	@Column(name = "created_Dt", length = 7, nullable = false, updatable = false)
	@CreationTimestamp
	private Date created_Dt;
	@Column(name = "updated_Dt", length = 7)
	@UpdateTimestamp
	private Date updated_Dt;

}
