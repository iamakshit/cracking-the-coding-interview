package com.java.tech.common;

public class CustomException extends Exception {

	/**
	 * LESSONS LEARNT: 1. Exception class is always extends and not implement 2. new
	 * Exception("message"); is very much possible
	 */
	private static final long serialVersionUID = 6332072710827106112L;

	private String message;

	public CustomException(String message) {
		this.setMessage(message);

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
