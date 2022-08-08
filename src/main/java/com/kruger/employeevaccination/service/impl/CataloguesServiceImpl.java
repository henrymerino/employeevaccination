package com.kruger.employeevaccination.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kruger.employeevaccination.entities.CatalogueDetail;
import com.kruger.employeevaccination.repository.CatalogueDetailRepository;
import com.kruger.employeevaccination.repository.CatalogueRepository;
import com.kruger.employeevaccination.service.CataloguesService;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Service
@RequiredArgsConstructor
@Transactional
public class CataloguesServiceImpl implements CataloguesService {
	
	@Autowired
	private CatalogueDetailRepository catalogueDetailRepository;
	
	@Autowired
	private CatalogueRepository catalogueRepository;
	
	@Override
	public List<CatalogueDetail> getCatalogues(String abbreviation) {
		return this.catalogueDetailRepository.findByAbbreviationDetail(abbreviation);
	}

	@Override
	public CatalogueDetail save(CatalogueDetail catalogueDetail) {
		return catalogueDetailRepository.save(catalogueDetail);
	}
}
