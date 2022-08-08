package com.kruger.employeevaccination.entities;

import java.io.Serializable;

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
public class CatalogueDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "catalogue_detail_seq", sequenceName = "catalogue_detail_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "catalogue_detail_seq")
    @Column(name = "id_catalogue_detail", unique = true, nullable = false, precision = 131089, scale = 0)
    private int idCatalogueDetail;
    @Column(name = "abbreviation_detail", length = 20)
    private String abbreviationDetail;
    @Column(name = "name_detail", length = 250)
    private String nameDetail;
    @Column(name = "description_detail", length = 250)
    private String descriptionDetail;
    @Column(name = "status_detail", columnDefinition = "boolean default true")
    private Boolean statusDetail;
    @ManyToOne
    @JsonBackReference
    private Catalogue catalogue;
}
