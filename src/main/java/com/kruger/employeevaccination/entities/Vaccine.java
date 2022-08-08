package com.kruger.employeevaccination.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Vaccine implements Serializable{

	private static final long serialVersionUID = 1L;
	
	  @Id
	    @SequenceGenerator(name = "vaccine_seq", sequenceName = "vaccine_seq", allocationSize = 1)
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vaccine_seq")
	    @Column(name = "id_vaccine", unique = true, nullable = false, precision = 131089, scale = 0)
	    private Integer idVaccine;
	   
	  	@Column(name = "type_vaccine", length = 20)
	    private Integer typeVaccine;

	    @Column(name = "vaccination_date")
	    private LocalDate vaccinationDate;

	    @Column(name = "number_doses")
	    private Integer numberDoses;

	    @ManyToOne
	    @JsonBackReference
	    private Employee employee;

}
