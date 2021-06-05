package com.tweetapp.tweetservice.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

/**
 * @author Nithya T
 *
 */
public class TweetDto {
	
	@JsonAlias("_id")
	private String id;
	private String message;
	
	public TweetDto() {
		super();
	}

	public TweetDto(String id, String message) {
		super();
		this.id = id;
		this.message = message;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "TweetDto [id=" + id + ", message=" + message + "]";
	}
	

}
