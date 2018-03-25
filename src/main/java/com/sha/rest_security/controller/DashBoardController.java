package com.sha.rest_security.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sha.rest_security.dto.BaseResponse;
import com.sha.rest_security.util.ResponseUtil;

@RestController
@RequestMapping("/api")
public class DashBoardController {
	
	  @RequestMapping(value="/greet",method = RequestMethod.GET)
		ResponseEntity<BaseResponse> greet() {
		  return ResponseUtil.getSuccessResponse("Hello Testing","000");
	  }
	  
	  
}
