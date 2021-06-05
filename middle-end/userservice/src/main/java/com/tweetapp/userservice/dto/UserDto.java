package com.tweetapp.userservice.dto;

/**
 * @author Nithya T
 *
 */
public class UserDto {
	
	private String loginId;
	private String password;
	private boolean isLogIn;
	public UserDto() {
		super();
	}
	public UserDto(String loginId, String password, boolean isLogIn) {
		super();
		this.loginId = loginId;
		this.password = password;
		this.isLogIn = isLogIn;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isLogIn() {
		return isLogIn;
	}
	public void setLogIn(boolean isLogIn) {
		this.isLogIn = isLogIn;
	}
	@Override
	public String toString() {
		return "UserDto [loginId=" + loginId + ", password=" + password + ", isLogIn=" + isLogIn + "]";
	}
	
	
	
}
