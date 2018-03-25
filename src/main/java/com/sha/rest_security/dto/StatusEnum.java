package com.sha.rest_security.dto;

public enum StatusEnum {
	SUCCESS("SUCCESS"),
	ERROR("SUCCESS"),
	FAILED("ERROR");
	
	private String status;
	private StatusEnum(String status) {
		this.status=status;
	}
	
	public String getStatus() {
		return status;
	}
}
