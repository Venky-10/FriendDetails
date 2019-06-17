package com.example.demo.util;

public class ErrorMessage {

	private String Status;
	public ErrorMessage(String status, String message) {
		Status = status;
		this.message = message;
	}
	private String message;
	
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
