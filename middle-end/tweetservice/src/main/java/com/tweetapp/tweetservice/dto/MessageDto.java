package com.tweetapp.tweetservice.dto;

/**
 * @author Nithya T
 *
 */
public class MessageDto {
	
	private String id;
	private String message;
	
	public MessageDto() {
		super();
	}

	public MessageDto(String id, String message) {
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
		return "MessageDto [id=" + id + ", message=" + message + "]";
	}
	
	

}
