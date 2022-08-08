package com.kruger.employeevaccination.commons.response;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class LoginResult {
	
	@NonNull
	private String token;
}
