package com.kruger.employeevaccination.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kruger.employeevaccination.entities.Catalogue;
import com.kruger.employeevaccination.repository.CatalogueRepository;
import com.kruger.employeevaccination.service.CatalogueService;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Service
@RequiredArgsConstructor
@Transactional
public class CatalogueServiceImpl implements CatalogueService{

	@Autowired
	private CatalogueRepository CatalogueRepository; 
	
	@Override
	public Catalogue save(Catalogue catalogue) {
		return CatalogueRepository.save(catalogue);
	}

	@Override
	public List<Catalogue> getCatalogue(String abbreviation) {
		return CatalogueRepository.findByAbbreviationDetail(abbreviation);
	}


}
