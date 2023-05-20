package com.insuranceApp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insuranceApp.payload.UserRequestPayload;
import com.insuranceApp.payload.UserResponsePayload;
import com.insuranceApp.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping ("insurance-api/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	//API allows to create a record in database for new User.
	@PostMapping ("/create")
	@ApiOperation (value = "user details", notes = "creates a new user record in database", response = ResponseEntity.class)
	public ResponseEntity <UserResponsePayload> createUser (@Valid @RequestBody UserRequestPayload userRequestPayload) {
		
		UserResponsePayload user = this.userService.createUser(userRequestPayload);
		
		return new ResponseEntity<> (user, HttpStatus.CREATED);		
	}
	
	//API allows to update the information in database for a user.
	@PutMapping ("/update/{userId}")
	@ApiOperation (value = "user details for update, user id", notes = "updates existing user record in database", response = ResponseEntity.class)
	public ResponseEntity<UserResponsePayload> updateUser (@Valid @RequestBody UserRequestPayload userRequestPayload,
														   @PathVariable Integer userId){
		
		UserResponsePayload userUpdated = this.userService.updateUserInfo(userRequestPayload, userId);
		
		return new ResponseEntity<> (userUpdated, HttpStatus.OK);
	}
	
}
