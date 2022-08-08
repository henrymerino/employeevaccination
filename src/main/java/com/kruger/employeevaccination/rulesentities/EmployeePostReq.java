package com.kruger.employeevaccination.rulesentities;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class EmployeePostReq implements Serializable {

    private static final long serialVersionUID = 1L;

    @Size(max = 10, message = "es obligatorio ingresar 10 dígitos entre 0 y 9")
    @Pattern(regexp = "^[0-9\\t]*$", message = "es obligatorio ingresar 10 dígitos entre 0 y 9")
    private String identification;
    @Size(min=1, max = 250, message = "es obligatorio, se permite solo letras mayúsculas o minúsculas, no se permite caracteres especiales y el tamaño máximo es 250 caracteres")
    @Pattern(regexp = "^[a-zñáéíóúA-ZÑÁÉÍÓÚ\\s]*$", message = "es obligatorio, se permite solo letras mayúsculas o minúsculas, no se permite caracteres especiales y el tamaño máximo es 250 caracteres")
    private String firstname;
    @Size(min=1, max = 250, message = "es obligatorio, se permite solo letras mayúsculas o minúsculas, no se permite caracteres especiales y el tamaño máximo es 250 caracteres")
    @Pattern(regexp = "^[a-zñáéíóúA-ZÑÁÉÍÓÚ\\s]*$", message = "es obligatorio, se permite solo letras mayúsculas o minúsculas, no se permite caracteres especiales y el tamaño máximo es 250 caracteres")
    private String lastname;
    @Email(message = "no cumple con el formato de correo electrónico")
    private String email;
}
