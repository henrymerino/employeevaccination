package com.kruger.employeevaccination.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kruger.employeevaccination.commons.bo.VaccinesBO;
import com.kruger.employeevaccination.entities.CatalogueDetail;
import com.kruger.employeevaccination.entities.Employee;
import com.kruger.employeevaccination.entities.Vaccine;
import com.kruger.employeevaccination.enumerations.EnumResponse;
import com.kruger.employeevaccination.exception.CustomValidationException;
import com.kruger.employeevaccination.repository.CatalogueDetailRepository;
import com.kruger.employeevaccination.repository.EmployeeRepository;
import com.kruger.employeevaccination.repository.VaccinneRepository;
import com.kruger.employeevaccination.rulesentities.VaccinePostReq;
import com.kruger.employeevaccination.service.VaccinesService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class VaccinesServiceImpl implements VaccinesService {

	@Autowired
	private VaccinneRepository vaccineRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private CatalogueDetailRepository catDetRepository;
	@Autowired
	private VaccinesBO vaccinesBO;

	@Override
	public Vaccine postVaccine(String identification, VaccinePostReq vaccinePostReq) throws CustomValidationException {
		Vaccine vaccine = new Vaccine();
		Employee employee = this.employeeRepository.findByIdentificationEmployee(identification);
		if (employee == null)
			throw new CustomValidationException(EnumResponse.NO_EXIST);

		if (!employee.getVaccinationStatus())
			throw new CustomValidationException(EnumResponse.NO_REGISTER_VACCINES);

		List<CatalogueDetail> catalogueDetails = this.catDetRepository.findByAbbreviationDetail("vaccines");
		CatalogueDetail catalogo = this.catDetRepository.getById(vaccinePostReq.getVaccine());
		if (catalogueDetails.stream()
				.filter(cd -> cd.getAbbreviationDetail().equalsIgnoreCase(catalogo.getAbbreviationDetail())).count() != 1)
			throw new CustomValidationException(EnumResponse.INCORRECT_VACCINE);

		vaccine = this.vaccinesBO.vaccinePostReqToVaccine(employee, vaccine, vaccinePostReq);
		return this.vaccineRepository.save(vaccine);
	}
}
