package com.sha.rest_security.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class SignUpRequest {
	
	@JsonProperty("UserName")
	private String userName;
	
	@JsonProperty("Password")
	private String password;
	
	@JsonProperty("Role")
	private String role;
	
	public SignUpRequest(String userName, String password,String role) {
		super();
		this.userName = userName;
		this.password = password;
		this.role = role;
	}

	public SignUpRequest() {
		super();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
