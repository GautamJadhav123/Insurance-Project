package com.insuranceApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.insuranceApp.payload.User_PolicyDto;
import com.insuranceApp.service.User_PolicyService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping ("/insurance-api/user_policy")
public class User_PolicyController {
	
	
	@Autowired
	private User_PolicyService userPolicyService;
	
	//API creates a record in database if user buys a particular policy and stores the relevant information alongside.
	@PostMapping ("/buy/{userId}/{policyId}")
	@ApiOperation (value = "user id, policy id, term plan, paying period", notes = "creates a new record in database for each policy buyed by user", response = ResponseEntity.class)
	public ResponseEntity<User_PolicyDto> buyPolicyToUser(@PathVariable Integer userId,
														  @PathVariable Integer policyId,
														  @RequestParam String termPlan,
														  @RequestParam String periodOfPaying){
		
		User_PolicyDto userPolicyDto = this.userPolicyService.buyPolicyToUser(userId, policyId, termPlan, periodOfPaying);
		
		return new ResponseEntity<> (userPolicyDto, HttpStatus.OK);
		
	}
	
	

}
