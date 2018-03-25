package com.sha.rest_security.util;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.sha.rest_security.dto.BaseResponse;
import com.sha.rest_security.dto.Error;
import com.sha.rest_security.dto.StatusEnum;

public class ResponseUtil {
   public static ResponseEntity<BaseResponse> getSuccessResponse(Object resBodyObj,String statusCode){
	   BaseResponse response=new BaseResponse(StatusEnum.SUCCESS,statusCode,resBodyObj);
	   return new ResponseEntity<>(response, HttpStatus.OK);
	}
   
   public static ResponseEntity<BaseResponse> getErrorResponse(List<Error> errorList,String statusCode){
	   BaseResponse response=new BaseResponse(StatusEnum.ERROR, statusCode, errorList);
	   return new ResponseEntity<>(response, HttpStatus.OK);
	}
   
}
