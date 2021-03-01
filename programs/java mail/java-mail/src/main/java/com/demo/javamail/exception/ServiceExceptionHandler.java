package com.demo.javamail.exception;

import java.util.Arrays;

import com.demo.javamail.model.BaseMessage;
import com.demo.javamail.model.BaseModel;
import com.demo.javamail.model.BaseResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice  /// ***** It works for every controller
public class ServiceExceptionHandler {

	private static Logger logger = LoggerFactory.getLogger(ServiceExceptionHandler.class);

	@ExceptionHandler({ Throwable.class })
	private ResponseEntity<BaseResponse<BaseModel>> handleException(Exception exceptino, WebRequest reqeust) {
		logger.info("Exception Handler ", exceptino);

		// return new ResponseEntity<>(BaseResponse.<BaseModel>builder().success(false)
		// 		.messages(
		// 				Arrays.asList(BaseMessage.builder().code("SRVR001").message("Server error").type("E").build()))
		// 		.build(), HttpStatus.OK);
		return new ResponseEntity<>(BaseResponse.<BaseModel>builder().success(false)
				.messages(
						Arrays.asList(BaseMessage.builder().code("lbl_serverError").message("Server Error Occurred").type("E").build()))
				.build(), HttpStatus.OK);
	}

	@ExceptionHandler({ ServiceException.class })
	private ResponseEntity<BaseResponse<BaseModel>> handleServiceException(ServiceException e) {
		logger.info("Exception Handler ", e);

		return new ResponseEntity<>(
				BaseResponse.<BaseModel>builder().success(false).messages(Arrays.asList(e.getBaseMessage())).build(),
				HttpStatus.OK);
	}

}