package com.sha.rest_security.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class LoginInfo {
	
	@JsonProperty("UserName")
	private String userName;
	
	@JsonProperty("Password")
	private String password;
	
	@JsonProperty("RememberMe")
	private boolean rememberMe;

	public LoginInfo(String userName, String password,boolean rememberMe) {
		super();
		this.userName = userName;
		this.password = password;
		this.rememberMe = rememberMe;
	}

	public LoginInfo() {
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

	public boolean isRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(boolean rememberMe) {
		this.rememberMe = rememberMe;
	}
}
