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
@Table(name = "PASSPORT_APP_DTLS")
public class PassportAppDtlsEntity {

	@GeneratedValue
	@Id
	@Column(name = "APP_ID", length = 10)
	private Integer appId;
	@Column(name = "PASSPORT_NUMBER", length = 10)
	private String passportNumber;
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
