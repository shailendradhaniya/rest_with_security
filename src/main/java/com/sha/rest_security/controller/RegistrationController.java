package com.sha.rest_security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sha.rest_security.dto.SignUpRequest;
import com.sha.rest_security.dto.SignUpResponse;
import com.sha.rest_security.service.MyUserDetailService;

@RestController
@RequestMapping("/register")
public class RegistrationController {
	
	@Autowired
	private MyUserDetailService myUserDetailService;
	
	  @RequestMapping(value="/signup",method = RequestMethod.POST)
		ResponseEntity<SignUpResponse> signUp(@RequestBody SignUpRequest signUpRequest) {
		 
		return new ResponseEntity<SignUpResponse>(new SignUpResponse(HttpStatus.UNAUTHORIZED.name(),String.valueOf(HttpStatus.UNAUTHORIZED.value()),""),HttpStatus.UNAUTHORIZED);
		}
	  
	  
}
