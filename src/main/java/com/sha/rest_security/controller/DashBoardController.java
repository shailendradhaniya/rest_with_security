package com.sha.rest_security.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DashBoardController {
	
	  @RequestMapping(value="/greet",method = RequestMethod.GET)
		ResponseEntity<String> greet() {
		  return new ResponseEntity<>("Success secured api",HttpStatus.OK);
	  }
	  
	  
}
