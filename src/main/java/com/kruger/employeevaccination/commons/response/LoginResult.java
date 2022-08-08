package com.kruger.employeevaccination.commons.response;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Login response object containing the JWT
 *
 * @author imesha
 */
@Data
@RequiredArgsConstructor
public class LoginResult {
	
	@NonNull
	private String token;
}
