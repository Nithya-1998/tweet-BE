package com.tweetapp.userservice.bean;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Nithya T
 *
 */
@Data
@Getter
@Setter
@Document(collection = "user")
public class User {

	@Id
	private String _id;
	private String loginId;
	private String firstName;
	private String lastName;
	private String emailId;
	private String phnNum;
	private String password;
	private boolean isLogIn;
	private List<String> role = new ArrayList<>();

	public User(String _id, String loginId, String firstName, String lastName, String emailId, String phnNum,
			String password, boolean isLogIn, List<String> role) {
		super();
		this._id = _id;
		this.loginId = loginId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.phnNum = phnNum;
		this.password = password;
		this.isLogIn = isLogIn;
		this.role = role;
	}

	public boolean isLoggedIn() {
		return isLogIn;
	}

	public void setLoggedIn(boolean isLogIn) {
		this.isLogIn = isLogIn;
	}


	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhnNum() {
		return phnNum;
	}

	public void setPhnNum(String phnNum) {
		this.phnNum = phnNum;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<String> getRole() {
		return role;
	}

	public void setRole(List<String> role) {
		role.add("USER");
		role.add("ADMIN");
		this.role = role;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_id == null) ? 0 : _id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (_id == null) {
			if (other._id != null)
				return false;
		} else if (!_id.equals(other._id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [_id=" + _id + ", loginId=" + loginId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailId=" + emailId + ", phnNum=" + phnNum + ", password=" + password + ", isLoggedIn="
				+ isLogIn + ", role=" + role + "]";
	}

}
