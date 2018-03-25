package com.sha.rest_security.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Error {
	
	@JsonProperty("ErrorCode")
	private String errorCode;
	
	@JsonProperty("Message")
	private String message;
	
	@JsonProperty("Description")
	private String description;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Error(String errorCode, String message, String description) {
		super();
		this.errorCode = errorCode;
		this.message = message;
		this.description = description;
	}

	public Error(String message, String description) {
		super();
		this.message = message;
		this.description = description;
	}

	public Error() {
		super();
	}	

}
