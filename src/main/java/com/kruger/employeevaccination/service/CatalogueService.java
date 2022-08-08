package com.kruger.employeevaccination.service;

import java.util.List;

import com.kruger.employeevaccination.entities.Catalogue;

public interface CatalogueService {
	Catalogue save(Catalogue catalogue);
	List<Catalogue> getCatalogue(String abbreviation);
	
}
