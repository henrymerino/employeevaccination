package com.kruger.employeevaccination.api;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kruger.employeevaccination.commons.bo.CommonBO;
import com.kruger.employeevaccination.commons.response.InfoResponse;
import com.kruger.employeevaccination.commons.util.Constants;
import com.kruger.employeevaccination.entities.Vaccine;
import com.kruger.employeevaccination.enumerations.EnumResponse;
import com.kruger.employeevaccination.exception.CustomValidationException;
import com.kruger.employeevaccination.rulesentities.VaccinePostReq;
import com.kruger.employeevaccination.service.VaccinesService;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@RestController
@RequestMapping(path = "/api")
@RequiredArgsConstructor
@Slf4j
public class VaccinesResources {

	private Map<String, Object> response = null;
    private InfoResponse infoResponse;
    private Vaccine vaccine;
    private String info;
    @Autowired
    private CommonBO commonBO;
    @Autowired
    private final VaccinesService vaccinessService;
    
    @PostMapping("/employees/vaccines")
    public ResponseEntity<?> postEmployees(@Valid @RequestBody VaccinePostReq vaccinePostReq, BindingResult result) {
        this.response = new HashMap<>();
        this.infoResponse = new InfoResponse();
        if (result.hasErrors()) {
            this.infoResponse = this.commonBO.fillInfo(result);
            this.response.put(Constants.Messages.INFO_RESPONSE, infoResponse);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        try {
            this.vaccine = this.vaccinessService.postVaccine(vaccinePostReq.getIdentification(), vaccinePostReq);
            this.info = Constants.Messages.REGISTER_OK;
            response.put(Constants.Messages.VACCINE, this.info);
        } catch (DataAccessException e) {
            infoResponse = this.commonBO.fillInfo(EnumResponse.ERROR_DB);
            response.put(Constants.Messages.INFO_RESPONSE, infoResponse);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (CustomValidationException cvex) {
            infoResponse = this.commonBO.fillInfo(cvex.getCode(), cvex.getMessage());
            response.put(Constants.Messages.INFO_RESPONSE, infoResponse);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
        	log.error("error {}", ex.getMessage());
            infoResponse = this.commonBO.fillInfo(EnumResponse.ERROR_DB);
            response.put(Constants.Messages.INFO_RESPONSE, infoResponse);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
