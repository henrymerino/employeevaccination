package com.kruger.employeevaccination.commons.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kruger.employeevaccination.commons.response.EmployeePostRes;
import com.kruger.employeevaccination.entities.Employee;
import com.kruger.employeevaccination.entities.Role;
import com.kruger.employeevaccination.entities.Users;
import com.kruger.employeevaccination.rulesentities.EmployeePatchReq;
import com.kruger.employeevaccination.rulesentities.EmployeePostReq;
import com.kruger.employeevaccination.rulesentities.EmployeePutReq;

@Service
public class EmployeesBO {

	
	private final PasswordEncoder passwordEncoder;
	
	

	@Autowired
	public EmployeesBO(PasswordEncoder passwordEncoder) {
		super();
		this.passwordEncoder = passwordEncoder;
	}

	public Employee employeePostReqToEmployee(Employee employee, EmployeePostReq employeePostReq) {
		employee.setIdentification(employeePostReq.getIdentification());
		employee.setFirstname(employeePostReq.getFirstname());
		employee.setLastname(employeePostReq.getLastname());
		employee.setEmail(employeePostReq.getEmail());
		employee.setBirthdate(null);
		employee.setAddress("");
		employee.setCellphone("");
		employee.setVaccinationStatus(false);
		return employee;
	}

	public EmployeePostRes employeeToEmployePostRes(Employee employee) {
		EmployeePostRes empPostRes = new EmployeePostRes();
		empPostRes.setEmployee(employee);
		return empPostRes;
	}

	public Employee patchEmployee(Employee employee, EmployeePatchReq empPatchReq) {
		employee.setBirthdate(empPatchReq.getBirthdate());
		employee.setAddress(empPatchReq.getAddress());
		employee.setCellphone(empPatchReq.getCellphone());
		employee.setVaccinationStatus(empPatchReq.getVaccinationStatus());
		return employee;
	}

	public Employee putEmployee(Employee employee, EmployeePutReq employeePutReq) {
		employee.setIdentification(employeePutReq.getIdentification());
		employee.setFirstname(employeePutReq.getFirstname());
		employee.setLastname(employeePutReq.getLastname());
		employee.setEmail(employeePutReq.getEmail());
		employee.setBirthdate(employeePutReq.getBirthdate());
		employee.setAddress(employeePutReq.getAddress());
		employee.setCellphone(employeePutReq.getCellphone());
		employee.setVaccinationStatus(employeePutReq.getVaccinationStatus());
		return employee;
	}

	public Users createUser(EmployeePostReq empReq) {
		Users user = new Users();
		user.setName(empReq.getFirstname().concat(" ").concat(empReq.getLastname()));
		user.setUsername(empReq.getFirstname());
		user.setPassword(this.passwordEncoder.encode(empReq.getIdentification()));
		return user;
	}

	public Role createRole(Users user) {
		Role rol = new Role();
		rol.setName("ROLE_EMPLOYEE");
		return rol;
	}
}
