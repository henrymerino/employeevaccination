/**
 * Nombre Clase: Constantes.java
 * <br> 
 * El contenido de este archivo est&aacute; protegido
 * por los Derechos de autor de la DIRECCI&Oacute;N GENERAL DE REGISTRO CIVIL,
 * IDENTIFICACI&Oacute;N Y CEDULACI&Oacute;N no se permite su reproducci&oacute;N o
 * distribuci&oacute;n sin una autorizaci&oacute;n de la INSTITUCI&Oacute;N 
 * y ser&aacute; penado por la ley seg&uacute;n se infrinja
 *  <br>
 * Fecha Creaci&oacute;n: 12/10/2021 <br>
 * Fecha Modificaci&oacute;n: <br>
 *  
 * <br>
 * Cambios
 * Importantes: <br>
 * 
 * @author Santiago Simba&ntilde;a
 * @version 1.0.0
 * @since jdk 11
 **/

package com.kruger.employeevaccination.commons.util;

public class Constants {

	public static final String FORMATO_FECHA = "dd/MM/yyyy";

	public static final class Autenticacion {
		public static final String SECRET = "Mav54321JmAv12345";
	}

	public static final class ObtencionCuenta {
		public static final String CHARSET = "UTF-8";
		public static final String ALGORITMO_AES = "PBEWithMD5AndDES";
	}

	public static final class Entities {
		public static final String SCHEMA = "employeevaccine";
	}

	public static final class Messages {
		public static final String INFO_RESPONSE = "infoResponse";
		public static final String EMPLOYEE = "employee";
		public static final String EMPLOYEES = "employees";
		public static final String CATALOGUES = "catalogues";
		public static final String VACCINE = "vaccine";
		public static final String REGISTER_VACCINES = "El registro de sus datos adicionales ha sido exitoso, ahora debe proceder a registrar sus vacunas en el método: /vaccines";
		public static final String REGISTER_FINAL = "El registro de sus datos adicionales ha sido exitoso.";
		public static final String REGISTER_OK = "El registro de datos ha sido exitoso.";
		public static final String UPDATE_OK = "Actualización de datos ha sido exitoso.";
	}

}
