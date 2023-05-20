package com.insuranceApp.service;

import com.insuranceApp.payload.UserRequestPayload;
import com.insuranceApp.payload.UserResponsePayload;

public interface UserService {
	
	public UserResponsePayload createUser (UserRequestPayload userRequestPayload);
	
	public UserResponsePayload updateUserInfo (UserRequestPayload userRequestPayload, Integer userId);

}
