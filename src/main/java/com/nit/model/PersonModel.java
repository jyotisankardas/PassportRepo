package com.nit.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class PersonModel {

	private Integer personId;
	private String firstName;
	private String lastName;
	private String email;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date dob;
	private char gender;
	private Date created_Dt;
	private Date updated_Dt;

}
