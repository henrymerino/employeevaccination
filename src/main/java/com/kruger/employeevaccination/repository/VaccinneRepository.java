package com.kruger.employeevaccination.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kruger.employeevaccination.entities.Vaccine;

@Repository
public interface VaccinneRepository extends JpaRepository<Vaccine, Integer> {
}
