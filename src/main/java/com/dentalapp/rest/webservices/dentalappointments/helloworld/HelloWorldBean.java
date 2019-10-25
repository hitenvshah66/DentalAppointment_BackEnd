package com.dentalapp.rest.webservices.dentalappointments.helloworld;

public class HelloWorldBean {

	private String message;

	public HelloWorldBean(String string) {
		// TODO Auto-generated constructor stub
		this.message = string;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}
	
	

	
}
