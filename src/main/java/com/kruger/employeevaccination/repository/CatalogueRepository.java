package com.kruger.employeevaccination.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kruger.employeevaccination.entities.Catalogue;

@Repository
public interface CatalogueRepository extends JpaRepository<Catalogue, Integer> {
	
	@Query("select c from Catalogue c"
			+ " where c.abbreviation = ?1")
	List<Catalogue> findByAbbreviationDetail(String abbreviation);

}
