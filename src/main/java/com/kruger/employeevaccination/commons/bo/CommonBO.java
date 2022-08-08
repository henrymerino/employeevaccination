package com.kruger.employeevaccination.commons.bo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.kruger.employeevaccination.commons.response.InfoResponse;
import com.kruger.employeevaccination.enumerations.EnumResponse;

@Service
public class CommonBO {


    public InfoResponse fillInfo(EnumResponse enumResponse) {
        InfoResponse infoResponse = new InfoResponse();
        infoResponse.setCode(enumResponse.getCode());
        infoResponse.setMessage(enumResponse.getMessage());
        return infoResponse;
    }

    public InfoResponse fillInfo(String Code, String mensaje) {
        InfoResponse infoResponse = new InfoResponse();
        infoResponse.setCode(Optional.ofNullable(Code).orElse(""));
        infoResponse.setMessage(Optional.ofNullable(mensaje).orElse(""));
        return infoResponse;
    }

    public InfoResponse fillInfo(BindingResult result) {
        InfoResponse infoResponse = new InfoResponse();
        StringBuilder sb = new StringBuilder();
        sb.append(EnumResponse.VALIDACIONES_CORREGIR.getMessage());
        sb.append(" ");

        List<String> errores = result.getFieldErrors().stream()
                .map(error -> "El campo '" + error.getField() + "' " + error.getDefaultMessage())
                .collect(Collectors.toList());
        sb.append(errores);

        infoResponse.setCode(EnumResponse.INCORRECTO.getCode());
        infoResponse.setMessage(sb.toString());
        return infoResponse;
    }

}
