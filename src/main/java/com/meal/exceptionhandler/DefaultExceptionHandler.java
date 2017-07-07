package com.meal.exceptionhandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(NotFoundException.class)
	public final ResponseEntity<ErrorMessage> defaultError(NotFoundException e) {
		ErrorMessage exceptionResponse = new ErrorMessage(e.getMessage(), e.getMethod());
		return new ResponseEntity<ErrorMessage>(exceptionResponse, new HttpHeaders(), HttpStatus.NOT_FOUND);
		
	}
	class ErrorMessage {
		private String message;
		private String method;
		public ErrorMessage(String message, String details){
			this.message = message;
			this.method = details;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public String getDetails() {
			return method;
		}
		public void setDetails(String details) {
			this.method = details;
		}
	}	
}
