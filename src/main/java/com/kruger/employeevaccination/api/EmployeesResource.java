package com.kruger.employeevaccination.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kruger.employeevaccination.commons.bo.CommonBO;
import com.kruger.employeevaccination.commons.bo.ValidationsBO;
import com.kruger.employeevaccination.commons.response.InfoResponse;
import com.kruger.employeevaccination.commons.util.Constants;
import com.kruger.employeevaccination.entities.Employee;
import com.kruger.employeevaccination.enumerations.EnumResponse;
import com.kruger.employeevaccination.exception.CustomValidationException;
import com.kruger.employeevaccination.rulesentities.EmployeePatchReq;
import com.kruger.employeevaccination.rulesentities.EmployeePostReq;
import com.kruger.employeevaccination.rulesentities.EmployeePutReq;
import com.kruger.employeevaccination.service.EmployeesService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path = "/api")
@RequiredArgsConstructor
@Slf4j
public class EmployeesResource {

	private Map<String, Object> response = null;
	private InfoResponse infoResponse;
	private Employee employee;
	private List<Employee> employees;
	private String info;

	@Autowired
	private CommonBO commonBO;
	@Autowired
	private ValidationsBO validationsBO;
	@Autowired
	private final EmployeesService employeesService;

	@PostMapping("/employee/create")
	public ResponseEntity<?> postEmployees(@Valid @RequestBody EmployeePostReq employeePostReq, BindingResult result) {
		this.response = new HashMap<>();
		this.infoResponse = new InfoResponse();
		if (result.hasErrors()) {
			this.infoResponse = this.commonBO.fillInfo(result);
			this.response.put(Constants.Messages.INFO_RESPONSE, infoResponse);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			this.validationsBO.employeePostValidation(employeePostReq.getIdentification());
			String resp = this.employeesService.postEmployees(employeePostReq);
			this.info = Constants.Messages.REGISTER_OK;
			response.put(Constants.Messages.INFO_RESPONSE, resp);
		} catch (DataAccessException e) {
			infoResponse = this.commonBO.fillInfo(EnumResponse.ERROR_DB);
			response.put(Constants.Messages.INFO_RESPONSE, infoResponse);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (CustomValidationException cvex) {
			infoResponse = this.commonBO.fillInfo(cvex.getCode(), cvex.getMessage());
			response.put(Constants.Messages.INFO_RESPONSE, infoResponse);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			log.error("Error {}", ex.getMessage());
			infoResponse = this.commonBO.fillInfo(EnumResponse.ERROR_DB);
			response.put(Constants.Messages.INFO_RESPONSE, infoResponse);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@PutMapping("/employee/createvaccinated")
	public ResponseEntity<?> putEmployees(@Valid @RequestBody EmployeePutReq employeePutReq, BindingResult result) {
		this.response = new HashMap<>();
		this.infoResponse = new InfoResponse();
		if (result.hasErrors()) {
			this.infoResponse = this.commonBO.fillInfo(result);
			this.response.put(Constants.Messages.INFO_RESPONSE, infoResponse);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			this.validationsBO.employeePostValidation(employeePutReq.getIdentification());
			this.employee = this.employeesService.getEmployeeByIdentification(employeePutReq.getIdentification(),
					employeePutReq);
			response.put(Constants.Messages.INFO_RESPONSE, Constants.Messages.UPDATE_OK);
		} catch (DataAccessException e) {
			infoResponse = this.commonBO.fillInfo(EnumResponse.ERROR_DB);
			response.put(Constants.Messages.INFO_RESPONSE, infoResponse);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (CustomValidationException cvex) {
			infoResponse = this.commonBO.fillInfo(cvex.getCode(), cvex.getMessage());
			response.put(Constants.Messages.INFO_RESPONSE, infoResponse);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			infoResponse = this.commonBO.fillInfo(EnumResponse.ERROR_DB);
			response.put(Constants.Messages.INFO_RESPONSE, infoResponse);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@DeleteMapping("/employee/delete/{id}")
	@ResponseBody
	public ResponseEntity<?> deleteEmployeeById(@PathVariable Integer id) {
		this.response = new HashMap<>();
		this.infoResponse = new InfoResponse();
		try {
			this.employeesService.deleteEmployee(id);
			response.put(Constants.Messages.EMPLOYEE, "Registro eliminado correctamente");
		} catch (DataAccessException e) {
			infoResponse = this.commonBO.fillInfo(EnumResponse.ERROR_DB);
			response.put(Constants.Messages.INFO_RESPONSE, infoResponse);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (CustomValidationException cvex) {
			infoResponse = this.commonBO.fillInfo(cvex.getCode(), cvex.getMessage());
			response.put(Constants.Messages.INFO_RESPONSE, infoResponse);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			infoResponse = this.commonBO.fillInfo(EnumResponse.ERROR_DB);
			response.put(Constants.Messages.INFO_RESPONSE, infoResponse);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PatchMapping("/employee/addinformation")
	public ResponseEntity<?> patchEmployees(@Valid @RequestBody EmployeePatchReq employeePatchReq, BindingResult result) {
		this.response = new HashMap<>();
		this.infoResponse = new InfoResponse();
		if (result.hasErrors()) {
			this.infoResponse = this.commonBO.fillInfo(result);
			this.response.put(Constants.Messages.INFO_RESPONSE, infoResponse);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			this.employee = this.employeesService.patchEmployee(employeePatchReq.getIdentification(), employeePatchReq);
			if (this.employee.getVaccinationStatus())
				this.info = Constants.Messages.REGISTER_VACCINES;
			else
				this.info = Constants.Messages.REGISTER_FINAL;
			response.put(Constants.Messages.INFO_RESPONSE, this.info);
		} catch (DataAccessException e) {
			infoResponse = this.commonBO.fillInfo(EnumResponse.ERROR_DB);
			response.put(Constants.Messages.INFO_RESPONSE, infoResponse);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (CustomValidationException cvex) {
			infoResponse = this.commonBO.fillInfo(cvex.getCode(), cvex.getMessage());
			response.put(Constants.Messages.INFO_RESPONSE, infoResponse);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			infoResponse = this.commonBO.fillInfo(EnumResponse.ERROR_DB);
			response.put(Constants.Messages.INFO_RESPONSE, infoResponse);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
