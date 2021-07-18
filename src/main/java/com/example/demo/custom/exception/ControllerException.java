package com.example.demo.custom.exception;

import org.springframework.stereotype.Component;

@Component
public class ControllerException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorCode;
	private String errorMessge;
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessge() {
		return errorMessge;
	}
	public void setErrorMessge(String errorMessge) {
		this.errorMessge = errorMessge;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public ControllerException(String errorCode, String errorMessge) {
		super();
		this.errorCode = errorCode;
		this.errorMessge = errorMessge;
	}
	public ControllerException() {
		super();
	}
	
	
	

}
