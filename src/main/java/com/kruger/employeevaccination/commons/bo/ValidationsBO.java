package com.kruger.employeevaccination.commons.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kruger.employeevaccination.commons.util.Validator;
import com.kruger.employeevaccination.enumerations.EnumResponse;
import com.kruger.employeevaccination.exception.CustomValidationException;
import com.kruger.employeevaccination.repository.EmployeeRepository;

@Service
public class ValidationsBO {	
	
	private EmployeeRepository employeeRepository;
		
	@Autowired
    public ValidationsBO(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	public void employeePostValidation(String identification) throws CustomValidationException {
        if (!Validator.validatorIdentification(identification))
            throw new CustomValidationException(EnumResponse.IDENTIFICATION_ERROR);
    }

}
