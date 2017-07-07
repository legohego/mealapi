package com.meal.exceptionhandler;

public class NotFoundException extends Exception {
	private String method;
	 public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public NotFoundException(String message, String method) {
	        super(message);
	        this.method = method;
	    }

}
