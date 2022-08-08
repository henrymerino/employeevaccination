package com.kruger.employeevaccination.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "employee_seq", sequenceName = "employee_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
	@Column(name = "id_employee", unique = true, nullable = false, precision = 131089, scale = 0)
	private int idEmployee;
	@Column(name = "identification",length = 10)
	private String identification;
	@Column(length = 250)
	private String firstname;
	@Column(length = 250)
	private String lastname;
	@Column(length = 250)
	private String email;
	private LocalDate birthdate;
	@Column(length = 250)
	private String address;
	@Column(length = 20)
	private String cellphone;
	@Column(columnDefinition = "boolean default false")
	private Boolean vaccinationStatus;

}
