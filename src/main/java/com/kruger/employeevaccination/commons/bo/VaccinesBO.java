package com.kruger.employeevaccination.commons.bo;

import org.springframework.stereotype.Service;

import com.kruger.employeevaccination.entities.Employee;
import com.kruger.employeevaccination.entities.Vaccine;
import com.kruger.employeevaccination.rulesentities.VaccinePostReq;

@Service
public class VaccinesBO {
	
	 public Vaccine vaccinePostReqToVaccine(Employee employee, Vaccine vaccine, VaccinePostReq vaccinePostReq) {
		 vaccine.setEmployee(employee);
		 vaccine.setTypeVaccine(vaccinePostReq.getVaccine());
		 vaccine.setVaccinationDate(vaccinePostReq.getVaccination_date());
		 vaccine.setNumberDoses(vaccinePostReq.getNumber_doses());
		 return vaccine;
    }

}
