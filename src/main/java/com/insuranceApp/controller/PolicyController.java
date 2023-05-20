package com.insuranceApp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insuranceApp.payload.ApiResponse;
import com.insuranceApp.payload.PolicyRequestPayload;
import com.insuranceApp.payload.PolicyResponsePayload;
import com.insuranceApp.service.PolicyService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping ("/insurance-api/policy")
public class PolicyController {
	
	@Autowired
	private PolicyService policyService;
	
	//creates a record for a new policy in database and associates with a insurance type.
	@PostMapping ("/create/{insuranceTypeId}")
	@ApiOperation (value = "policy details along with policy factors, insurance type id", notes = "creates a new policy record in database, allowed for admin only", response = ResponseEntity.class)
	public ResponseEntity<PolicyRequestPayload> createPolicy (@Valid @RequestBody PolicyRequestPayload policyReuestPayload,
															  @PathVariable Integer insuranceTypeId){
		
	 	PolicyRequestPayload policyA = this.policyService.createPolicy(policyReuestPayload, insuranceTypeId);
		
		return new ResponseEntity<>(policyA, HttpStatus.CREATED);
	}
	
	//fetches the policy for a user. 
	@GetMapping("/gettouser/{policyId}/{userId}")
	@ApiOperation (value = "user id, policy id", notes = "shows details of the selected policy for the user accordingly", response = ResponseEntity.class)
	public ResponseEntity<PolicyResponsePayload> getPolicyToUser (@PathVariable Integer policyId,
																  @PathVariable Integer userId){
	
		PolicyResponsePayload policyResult = this.policyService.getPolicyById(policyId, userId);
	
		return new ResponseEntity<> (policyResult, HttpStatus.OK);															
	}
	
	//deletes a particular policy.
	@DeleteMapping ("/delete/{policyId}")
	@ApiOperation (value = "user id", notes = "deletes a policy record in database", response = ResponseEntity.class)
	public ResponseEntity<ApiResponse> deletePolicy(@PathVariable Integer policyId){
		
		this.policyService.deletePolicy(policyId);
		
		return new ResponseEntity<> (new ApiResponse("Policy Deleted Successfully", true), HttpStatus.OK);
	}
	
	//fetches all the policies under selected insurance type for the user.
	@GetMapping ("/getalltouser/{insuranceId}/{userId}")
	@ApiOperation (value = "user id, insurance type id", notes = "shows all policies to user for the selected insurance type", response = ResponseEntity.class)
	public ResponseEntity<List<PolicyResponsePayload>> getAllPoliciesUnderInsuranceType(@PathVariable Integer insuranceId,
																					    @PathVariable Integer userId){
		
		List<PolicyResponsePayload> responsePolicies = this.policyService.getAllPoliciesUnderInsuranceType(insuranceId, userId);
		
		return new ResponseEntity<> (responsePolicies, HttpStatus.OK);
	}
}
