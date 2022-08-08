package com.kruger.employeevaccination.service.impl;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kruger.employeevaccination.entities.Employee;
import com.kruger.employeevaccination.entities.Role;
import com.kruger.employeevaccination.enumerations.EnumResponse;
import com.kruger.employeevaccination.exception.CustomValidationException;
import com.kruger.employeevaccination.repository.EmployeeRepository;
import com.kruger.employeevaccination.repository.RoleRepo;
import com.kruger.employeevaccination.repository.UserRepo;
import com.kruger.employeevaccination.rulesentities.EmployeePatchReq;
import com.kruger.employeevaccination.rulesentities.EmployeePostReq;
import com.kruger.employeevaccination.rulesentities.EmployeePutReq;
import com.kruger.employeevaccination.service.EmployeesService;
import com.kruger.employeevaccination.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class EmployeesServiceImpl implements EmployeesService {

	public static final Log LOG = LogFactory.getLog(EmployeesServiceImpl.class);

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private com.kruger.employeevaccination.commons.bo.EmployeesBO employeesBO;
	@Autowired
	private UserRepo userRepository;
	@Autowired
	private RoleRepo roleRepository;
	@Autowired
	private final UserService userService;

	@Override
	public String postEmployees(EmployeePostReq empReq) {
		Employee employee = new Employee();
		com.kruger.employeevaccination.entities.Users user = new com.kruger.employeevaccination.entities.Users();
		StringBuilder sb = new StringBuilder();
		user = this.employeesBO.createUser(empReq);
		user = this.userRepository.save(user);
		sb.append("Se creo el usuario: ");
		sb.append(user.getUsername());
		sb.append(", con password: ");
		sb.append(user.getPassword());
		Role role = this.employeesBO.createRole(user);
		this.userService.addRoleToUser(user.getUsername(), role.getName());
		sb.append(", tiene rol de: ");
		sb.append(role.getName());
		employee = this.employeesBO.employeePostReqToEmployee(employee, empReq);
		employee = this.employeeRepository.save(employee);
		return sb.toString();
	}

	@Override
	public Employee getEmployee(Integer id) throws CustomValidationException {
		return employeeRepository.findByIdEmployee(id);
	}

	@Override
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee patchEmployee(String identification, EmployeePatchReq employeePatchReq) throws CustomValidationException {
		Employee employee = this.employeeRepository.findByIdentificationEmployee(identification);
		if (employee == null)
			throw new CustomValidationException(EnumResponse.NO_EXIST);
			
		employee = this.employeesBO.patchEmployee(employee, employeePatchReq);
		return this.employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(Integer id) throws CustomValidationException {
		employeeRepository.deleteById(id);

	}

	@Override
	public Employee putEmployee(Integer id, EmployeePutReq employeePutReq) throws CustomValidationException {
		Employee employee = this.employeeRepository.findByIdEmployee(id);
		if (employee == null)
			throw new CustomValidationException(EnumResponse.NO_EXIST);

		employee = this.employeesBO.putEmployee(employee, employeePutReq);
		return this.employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getEmployeesFilter(Boolean vaccinationStatus, String typeVaccine, LocalDate initialDate,
			LocalDate finalDate) {
		return null;
	}

	@Override
	public Employee getEmployeeByIdentification(String identification, EmployeePutReq employeePutReq)
			throws CustomValidationException {

		Employee employee = this.employeeRepository.findByIdentificationEmployee(identification);
		if (employee == null)
			throw new CustomValidationException(EnumResponse.NO_EXIST);

		employee = this.employeesBO.putEmployee(employee, employeePutReq);
		return this.employeeRepository.save(employee);
	}

}
