package com.sha.rest_security.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class SignUpResponse {
	@JsonProperty("Status")
	private String status;
	
	@JsonProperty("StatusCode")
	private String statusCode;
	
	@JsonProperty("Token")
	private String token;

	public SignUpResponse() {
		super();
	}

	public SignUpResponse(String status, String statusCode, String token) {
		super();
		this.status = status;
		this.statusCode = statusCode;
		this.token = token;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
