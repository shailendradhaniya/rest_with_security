package com.sha.rest_security.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class BaseResponse {
	@JsonProperty("Status")
	private StatusEnum status;
	
	@JsonProperty("StatusCode")
	private String statusCode;
	
	@JsonProperty("ResultBody")
	private Object resultBody;
	
	@JsonProperty("Errors")
	private List<Error> errors;
	
	public BaseResponse() {
		super();
	}

	public BaseResponse(StatusEnum status, String statusCode,Object resObj) {
		super();
		this.status = status;
		this.statusCode = statusCode;
		this.resultBody=resObj;
	}
	
	public BaseResponse(StatusEnum status, String statusCode, List<Error> errors) {
		super();
		this.status = status;
		this.statusCode = statusCode;
		this.errors = errors;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public List<Error> getErrors() {
		return errors;
	}

	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}

	public Object getResultBody() {
		return resultBody;
	}

	public void setResultBody(Object resultBody) {
		this.resultBody = resultBody;
	}
}
