package com.kruger.employeevaccination.exception;

import java.io.Serializable;

import com.kruger.employeevaccination.enumerations.EnumResponse;

import lombok.Getter;


public class CustomValidationException extends Exception implements Serializable {
    private static final long serialVersionUID = 1L;

    @Getter
    private String code;
    @Getter
    private String message;

    public CustomValidationException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public CustomValidationException(EnumResponse enumResponse) {
        this.code = enumResponse.getCode();
        this.message = enumResponse.getMessage();
    }

}
