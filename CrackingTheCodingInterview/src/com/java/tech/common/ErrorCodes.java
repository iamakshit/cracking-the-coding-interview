package com.java.tech.common;

public enum ErrorCodes {

	
	EMPTY_STRING_ENTERED("Empty String Provided"),
	WRONG_INPUT_CASE("Wrong Input Case"),
	QUEUE_IS_EMPTY("Queue is Empty"),
	ONLY_POSITIVE_INPUT("Only Positive Input is required"),
	EMPTY_LIST("Empty List is present"),
	STACK_IS_EMPTY("Stack is Empty");
	
	String message;
	
	private ErrorCodes(String message)
	{
		this.message = message;
	}
	
	public String getMessage()
	{
		return message;
	}
	
}
