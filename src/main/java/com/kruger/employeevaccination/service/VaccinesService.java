package com.kruger.employeevaccination.service;

import org.springframework.stereotype.Service;

import com.kruger.employeevaccination.entities.Vaccine;
import com.kruger.employeevaccination.exception.CustomValidationException;
import com.kruger.employeevaccination.rulesentities.VaccinePostReq;

@Service
public interface VaccinesService {

	Vaccine postVaccine(String identification, VaccinePostReq vaccinePostReq) throws CustomValidationException;
}
