package com.sha.rest_security.controller;

import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sha.rest_security.bean.MyUserPrincipal;
import com.sha.rest_security.domains.Permission;
import com.sha.rest_security.dto.LoginInfo;
import com.sha.rest_security.dto.LoginResponse;
import com.sha.rest_security.dto.StatusEnum;
import com.sha.rest_security.service.MyUserDetailService;

@RestController
@RequestMapping("/")
public class LoginController {
	
	@Autowired
	private MyUserDetailService myUserDetailService;
	
	  @RequestMapping(value="login",method = RequestMethod.POST)
		ResponseEntity<LoginResponse> login(@RequestBody LoginInfo loginInfo) {
		  UserDetails userDetails=myUserDetailService.loadUserByUsername(loginInfo.getUserName());
		  MyUserPrincipal userPrincipal=(MyUserPrincipal)userDetails;
		  if(null!=userDetails) {
			  if(loginInfo.getPassword().equalsIgnoreCase(loginInfo.getPassword())) {
				  String jwtToken;
				  try {
					jwtToken=myUserDetailService.getUserToken(userPrincipal);
				} catch (UnrecoverableKeyException | KeyStoreException | NoSuchAlgorithmException | CertificateException
						| IOException e) {
					return new ResponseEntity<LoginResponse>(new LoginResponse(StatusEnum.ERROR,String.valueOf(HttpStatus.OK.value()),"Error generating token"),HttpStatus.OK);
				}
				  return new ResponseEntity<LoginResponse>(new LoginResponse(StatusEnum.SUCCESS,String.valueOf(HttpStatus.OK.value()),jwtToken),HttpStatus.OK); 
			  }
		  }
		return new ResponseEntity<LoginResponse>(new LoginResponse(StatusEnum.FAILED,String.valueOf(HttpStatus.UNAUTHORIZED.value()),""),HttpStatus.UNAUTHORIZED);
		}
	  
	  
}
