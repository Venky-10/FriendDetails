package com.example.demo.util;

public class FieldErrorMessage {

	private String field;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	private String message;
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public FieldErrorMessage(String field, String message) {
		super();
		this.field = field;
		this.message = message;
	}
	
}