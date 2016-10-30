package com.hit.web.model;

//import com.opensymphony.xwork2.ActionSupport;

public class User  {
	private String Name;
	private String Password;
	private String Email;
	private String UserID;
	private String Friends;

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}

	public String getUserId() {
		return UserID;
	}

	public void setId(String UserID) {
		this.UserID = UserID;
	}

	public String getFriends() {
		return Friends;
	}

	public void setFriends(String Friends) {
		this.Friends = Friends;
	}
}
