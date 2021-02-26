package com.yogiyo.review.exception;

public class ReviewException extends RuntimeException {

	public ReviewException() {}
	
	public ReviewException(String message) {
		super(message);
	}
	
	public ReviewException(String message, Throwable cause) {
		super(message, cause);
	}
}
