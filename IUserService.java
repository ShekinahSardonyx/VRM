package com.vrm.service;

import java.util.List;

import com.vrm.dto.UserDto;

public interface IUserService {

	public String validateUser(int userId ,String Password);
	public List<UserDto> removeUser(int id);
	public String SignOut(String message);
}
