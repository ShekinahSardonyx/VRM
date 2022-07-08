package com.vrm.dto;

import org.springframework.stereotype.Component;

@Component
public class UserDto {

	 private int userId;
	
	 private String password;
	
	 private String role;
	 

	 public UserDto() {}


	public UserDto(int userId, String password, String role) {
		super();
		this.userId = userId;
		this.password = password;
		this.role = role;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", password=" + password + ", role=" + role + "]";
	}
	
	
}
