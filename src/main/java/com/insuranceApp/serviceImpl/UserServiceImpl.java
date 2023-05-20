package com.insuranceApp.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insuranceApp.exception.ResourceNotFoundException;
import com.insuranceApp.model.User;
import com.insuranceApp.payload.UserRequestPayload;
import com.insuranceApp.payload.UserResponsePayload;
import com.insuranceApp.repository.UserRepository;
import com.insuranceApp.service.UserService;


@Service
public class UserServiceImpl implements UserService{
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	//creates a record in database for new user.
	@Override
	public UserResponsePayload createUser(UserRequestPayload userRequestPayload) {
		
		User user = this.modelMapper.map(userRequestPayload, User.class);
		User savedUser = this.userRepository.save(user);
		
		return this.modelMapper.map(savedUser, UserResponsePayload.class);
	}

	//updates the information/ fields in database for a user.
	@Override
	public UserResponsePayload updateUserInfo(UserRequestPayload userRequestPayload, Integer userId) {
		
		User user = this.userRepository.findById(userId).orElseThrow(()->
															         new ResourceNotFoundException("User", "User Id", userId));
		
		// explicitly set all the fields to update the information.
		user.setAge(userRequestPayload.getAge());
		user.setAnnualIncome(userRequestPayload.getAnnualIncome());
		user.setEmail(userRequestPayload.getEmail());
		user.setFirstName(userRequestPayload.getFirstName());
		user.setGender(userRequestPayload.getGender());
		user.setLastName(userRequestPayload.getLastName());
		user.setOccupation(userRequestPayload.getOccupation());
		user.setPassword(userRequestPayload.getPassword());
		user.setUsername(userRequestPayload.getUsername());
				
		return this.modelMapper.map(user, UserResponsePayload.class);
	}

}
