/**
 * Nombre Clase: InfoRespuesta.java
 * El contenido de este archivo esta protegido por los Derechos de autor
 * de la DIRECCI&Oacute;N GENERAL DE REGISTRO CIVIL, IDENTIFICACI&Oacute;N Y CEDULACI&Oacute;N
 * no se permite su reproducci&oacute;n o distribuci&oacute;n sin
 * una autorizaci&oacute;n de la INSTITUCI&Oacute;N y ser&aacute; penado
 * por la ley seg&uacute;n se infrinja
 *
 * <br>
 * Fecha Creaci&oacute;n:	 25/03/2019
 * <br>
 * Fecha Modificaci&oacute;n:
 * <br>
 * Clase que permite formatear la respuesta
 * Contiene la información de respuesta en caso de ejecución fallida de una transacción.
 * <br>
 * Cambios Importantes:
 * <br>
 * @author  Santiago Simba&ntilde;a
 * @version 1.0.0
 * @since jdk 1.8
 *
**/

package com.kruger.employeevaccination.commons.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class InfoResponse {

	private String code;
	private String message;
	
}
