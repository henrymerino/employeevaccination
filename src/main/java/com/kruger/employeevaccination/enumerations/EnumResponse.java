package com.kruger.employeevaccination.enumerations;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum EnumResponse {
    //2XX
    CORRECTO("000","Ok"),


    AUTH_CORRECTA("000", "Autenticación correcta."),

    //4XX
    AUTH_ERROR("401","Error de autenticacion: username o password incorrecto."),
    INCORRECTO("450", "Error"),
    IDENTIFICATION_ERROR("451", "La Cedula ingresada es Incorrecta"),
    VALIDACIONES_CORREGIR("452","Los datos ingresados no cumplen la validacion, Revisar:"),
    GENERAL_ERROR("453","Error general"),
    TOKEN_ERROR("454","El token enviado no es valido o esta caducado, por favor genere un nuevo token y vuelva a intentar."),
    TOKEN_ENTIDAD_ERROR("455","El token enviado no corresponde a su entidad, por favor genere un nuevo token y vuelva a intentar."),
    TRANSACCION_PEDIDO_ERROR("456", "Se debe ingresar numeroTransaccion o codigoPedido."),
    ERROR_DB("457", "Se presento un inconveniente con el registro o consulta de datos."),
    NO_EXIST("458", "El registro al que se refiere no existe en la base de datos."),
	NO_REGISTER_VACCINES("459", "No puede registra vacunas porque declaro que no esta vacunado."),
	INCORRECT_VACCINE("460", "La abreviacion de la vacuna es incorrecta, por favor revisar el catalogo de vacunas, en el metodo: catalogues, debe buscar por la abreviacion: vaccines");

    @Getter
    private final String code;
    @Getter
    private final String message;

}
