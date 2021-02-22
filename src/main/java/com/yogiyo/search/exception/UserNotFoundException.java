package com.yogiyo.search.exception;

public class UserNotFoundException extends StoreException {

	public UserNotFoundException(String message) {
		super(message);
	}
	public UserNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
