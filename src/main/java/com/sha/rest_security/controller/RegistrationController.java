package com.sha.rest_security.controller;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sha.rest_security.domains.User;
import com.sha.rest_security.dto.BaseResponse;
import com.sha.rest_security.dto.SignUpRequest;
import com.sha.rest_security.service.MyUserDetailService;
import com.sha.rest_security.util.ResponseUtil;

@RestController
@RequestMapping("/register")
public class RegistrationController {
	
	@Autowired
	private MyUserDetailService myUserDetailService;
	
	  @RequestMapping(value="/signup",method = RequestMethod.POST)
		ResponseEntity<BaseResponse> signUp(@RequestBody SignUpRequest signUpRequest) throws NoSuchAlgorithmException {
		 User user=myUserDetailService.addNewUser(signUpRequest);
		 return ResponseUtil.getSuccessResponse("Successfully Registered","000");
		}
	  
	  
}
