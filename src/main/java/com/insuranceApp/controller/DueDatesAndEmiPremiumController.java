package com.insuranceApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.insuranceApp.payload.DueDatesAndEmiPremiumResponsePayload;
import com.insuranceApp.service.DueDatesAndEmiPremiumService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/insurance-api/selectpolicy")
public class DueDatesAndEmiPremiumController {
	
	@Autowired
	private DueDatesAndEmiPremiumService dueDatesAndEmiPremiumService;
	
	
	//user gets the various paying period options available for the selected term plan with the corresponding installment amounts.
	//API gives dynamic response calculating all the values in runtime.
	@GetMapping ("/getpremiums/{userId}/{policyId}")
	@ApiOperation (value = "user id, policy id, term plan", notes = "shows the details for selected term plan and policy", response = ResponseEntity.class)
	public ResponseEntity<DueDatesAndEmiPremiumResponsePayload> getEmiPremiums(@PathVariable Integer userId,
																			   @PathVariable Integer policyId,
																			   @RequestParam String termPlan){
		
		DueDatesAndEmiPremiumResponsePayload object = this.dueDatesAndEmiPremiumService.getPremiumEmiDetails(userId,
																											 policyId,
																											 termPlan);
		
		
		return new ResponseEntity<>(object, HttpStatus.OK);
	}

}
