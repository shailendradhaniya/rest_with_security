package com.sha.rest_security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sha.rest_security.dto.BaseResponse;
import com.sha.rest_security.dto.LoginInfo;
import com.sha.rest_security.dto.LoginResponse;
import com.sha.rest_security.service.MyUserDetailService;
import com.sha.rest_security.util.ResponseUtil;

@RestController
@RequestMapping("/")
public class LoginController {
	
	@Autowired
	private MyUserDetailService myUserDetailService;
	
	  @RequestMapping(value="login",method = RequestMethod.POST)
		ResponseEntity<BaseResponse> login(@RequestBody LoginInfo loginInfo) {
		LoginResponse loginResponse=myUserDetailService.login(loginInfo);
		return ResponseUtil.getSuccessResponse(loginResponse,"000");
		}
	  
	  
}
