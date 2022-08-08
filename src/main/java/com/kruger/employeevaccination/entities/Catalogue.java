package com.kruger.employeevaccination.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Catalogue implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "catalogue_seq", sequenceName = "catalogue_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "catalogue_seq")
    @Column(name = "id_catalogue", unique = true, nullable = false, precision = 131089, scale = 0)
    private int idCatalogue;
    @Column(length = 20)
    private String abbreviation;
    @Column(length = 250)
    private String name;
    @Column(length = 250)
    private String description;
    @Column(columnDefinition = "boolean default true")
    private Boolean status;
    @OneToMany(mappedBy = "catalogue", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<CatalogueDetail> catalogueDetails = new ArrayList<>();
}
