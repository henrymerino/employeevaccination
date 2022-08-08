package com.kruger.employeevaccination.rulesentities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import lombok.Data;

@Data
public class VaccinePostReq implements Serializable {

    private static final long serialVersionUID = 1L;

    @Size(max = 10, message = "es obligatorio ingresar 10 dígitos entre 0 y 9")
    @Pattern(regexp = "^[0-9\\t]*$", message = "es obligatorio ingresar 10 dígitos entre 0 y 9")
    private String identification;
    private Integer vaccine;
    private LocalDate vaccination_date;
    @NotNull
    @Min(1)
    @Max(9)
    private Integer number_doses;
}
