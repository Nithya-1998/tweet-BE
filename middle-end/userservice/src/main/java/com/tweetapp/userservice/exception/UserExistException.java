package com.tweetapp.userservice.exception;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FOUND, reason = "User already exist")
public class UserExistException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserExistException(String message) {
		super(message);
	}

}
