package com.kruger.employeevaccination.service;

import java.time.LocalDate;
import java.util.List;

import com.kruger.employeevaccination.entities.Employee;
import com.kruger.employeevaccination.exception.CustomValidationException;
import com.kruger.employeevaccination.rulesentities.EmployeePatchReq;
import com.kruger.employeevaccination.rulesentities.EmployeePostReq;
import com.kruger.employeevaccination.rulesentities.EmployeePutReq;


public interface EmployeesService {
    String postEmployees(EmployeePostReq employeePostReq);

    Employee getEmployee(Integer id) throws CustomValidationException;

	List<Employee> getEmployees();

	Employee patchEmployee(String identification, EmployeePatchReq employeePatchReq) throws CustomValidationException;

	void deleteEmployee(Integer id) throws CustomValidationException;

	Employee putEmployee(Integer id, EmployeePutReq employeePutReq) throws CustomValidationException;

	List<Employee> getEmployeesFilter(Boolean vaccinationStatus, String typeVaccine, LocalDate initialDate, LocalDate finalDate);
	
	Employee getEmployeeByIdentification(String identification, EmployeePutReq employeePutReq) throws CustomValidationException;
}
