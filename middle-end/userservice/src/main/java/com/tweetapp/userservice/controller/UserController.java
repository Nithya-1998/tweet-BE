package com.tweetapp.userservice.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweetapp.userservice.bean.User;
import com.tweetapp.userservice.dto.UserDto;
import com.tweetapp.userservice.exception.Message;
import com.tweetapp.userservice.exception.UserExistException;
import com.tweetapp.userservice.exception.UserNotFoundException;
import com.tweetapp.userservice.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

/**
 * @author Nithya T
 *
 */
@RestController
@RequestMapping("/api/v1.0/tweets")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
	
	@Autowired
	public UserService userService;
	
	@Operation(summary = "This is to fetch all loggedIn users from db")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",
					description = "Fetched all loggedIn users from Db",
					content = {@Content(mediaType = "application/json")}),
			@ApiResponse(responseCode = "500",
			description = "Currently service is not available",
			content = @Content)
	})
	@GetMapping("/users/all")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@Operation(summary = "This is to fetch user by loginId from db")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",
					description = "Fetched particular user from Db",
					content = {@Content(mediaType = "application/json")}),
			@ApiResponse(responseCode = "401",
			description = "User unauthorized/not found",
			content = @Content),
			@ApiResponse(responseCode = "500",
			description = "Currently service is not available",
			content = @Content)
	})
	@GetMapping("/user/search/{loginId}")
	public User getUserById(@PathVariable String loginId) throws UserNotFoundException {
		return userService.getUserById(loginId);
	}
	
	@PostMapping("/login")
	public User getUserById(@RequestBody UserDto userDto) throws UserNotFoundException {
		return userService.getUser(userDto);
	}
	
	@Operation(summary = "This is to insert new user in db")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",
					description = "User details saved successfully",
					content = {@Content(mediaType = "application/json")}),
			@ApiResponse(responseCode = "302",
			description = "User already exist",
			content = @Content),
			@ApiResponse(responseCode = "500",
			description = "Currently service is not available",
			content = @Content)
	})
	@PostMapping("/register")
	public Message insertUser(@RequestBody User user)  throws UserExistException{
		return userService.insertUser(user);
	}
	
	@Operation(summary = "This is to update new password for that loginId in db")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",
					description = "User details updated successfully",
					content = {@Content(mediaType = "application/json")}),
			@ApiResponse(responseCode = "401",
			description = "User not found",
			content = @Content),
			@ApiResponse(responseCode = "500",
			description = "Currently service is not available",
			content = @Content)
	})
	@PutMapping("/forgot")
	public Message updateUser(@RequestBody UserDto user) throws UserNotFoundException {
		 return userService.updateUser(user);
	}
	
	@Operation(summary = "This is to logout the user")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",
					description = "User logged out successfully",
					content = {@Content(mediaType = "application/json")}),
			@ApiResponse(responseCode = "401",
			description = "User not found",
			content = @Content),
			@ApiResponse(responseCode = "500",
			description = "Currently service is not available",
			content = @Content)
	})
	@GetMapping("/logout/{loginId}")
	private Message logOutUser(@PathVariable String loginId) throws UserNotFoundException {
		return userService.logOutUser(loginId);
	}
		
}
