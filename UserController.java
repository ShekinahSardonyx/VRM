package com.vrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.vrm.dto.UserDto;
import com.vrm.service.IUserService;


@RestController
public class UserController {

	@Autowired
	public IUserService userService;
	
	
	@GetMapping("/validateUser/{UserId}/{password}")
	public String validateUser(@PathVariable("UserId") int id,@PathVariable("password") String password)
	{
		return userService.validateUser(id, password);
	}
	
	@DeleteMapping("/removeUser/{id}")
	public List<UserDto> deleteUser(@PathVariable("id") int id){
		 return userService.removeUser(id);
	}
	
    @GetMapping("/SignOut/{message}")
    public String SignOut(@PathVariable("message")String message) {
    	return userService.SignOut(message);
    }
}
