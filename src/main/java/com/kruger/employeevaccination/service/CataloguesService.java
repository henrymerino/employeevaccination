package com.kruger.employeevaccination.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kruger.employeevaccination.entities.CatalogueDetail;

@Service
public interface CataloguesService {

	List<CatalogueDetail> getCatalogues(String abbreviation);
	CatalogueDetail save(CatalogueDetail catalogueDetail); 
}
