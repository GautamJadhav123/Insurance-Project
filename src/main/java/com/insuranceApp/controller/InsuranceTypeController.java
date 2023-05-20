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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.insuranceApp.payload.ApiResponse;
import com.insuranceApp.payload.InsuranceTypeDto;
import com.insuranceApp.service.InsuranceTypeService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping ("/insurance-api/insurancetype")
public class InsuranceTypeController {
	
	@Autowired
	private InsuranceTypeService insruanceTypeService;
	
	//API allows to create insurance type.
	@PostMapping ("/create")
	@ApiOperation (value = "insurance type details", notes = "creates a new insurance type record in database", response = ResponseEntity.class)
	public ResponseEntity<InsuranceTypeDto> createInsuranceType (@Valid @RequestBody InsuranceTypeDto insuranceTypeDto){
		
		InsuranceTypeDto insuranceType = this.insruanceTypeService.createInsuranceType(insuranceTypeDto);
		return new ResponseEntity<> (insuranceType, HttpStatus.CREATED);
	}
	
	//API allows to fetch all insurance types available in database
	@GetMapping ("/getall")
	@ApiOperation (value = "no parameters requried", notes = "shows all the insurance types available from the DB", response = ResponseEntity.class)
	public ResponseEntity<List<InsuranceTypeDto>> getAllInsuranceType(){
		
		List<InsuranceTypeDto> insuranceTypeDtos = this.insruanceTypeService.getAllInsuranceTypes();
		
		return new ResponseEntity<>(insuranceTypeDtos, HttpStatus.OK);
	}
	
	//API allows to delete a particular insurance type based on insuranceTypeId.
	@DeleteMapping ("/delete/{insuranceTypeId}")
	@ApiOperation (value = "insurance type id", notes = "deletes a insuracne type record in database", response = ResponseEntity.class)
	public ResponseEntity<ApiResponse> deleteInsuranceType(@PathVariable Integer insuranceTypeId){
		
		this.insruanceTypeService.deleteInsuranceType(insuranceTypeId);
		
		return new ResponseEntity<>(new ApiResponse("Insurance Type deleted", true), HttpStatus.OK);
	}

	//API allows to retrieve the list of insurance types containing the keyword provided by user.
/*/	@GetMapping ("/search")
 * @ApiOperation (value = "keyword related to insurance type name", notes = "shows the relevant insurance types to user", response = ResponseEntity.class)
	public ResponseEntity<List<InsuranceTypeDto>> searchInsuranceTypeByKeyword (@RequestParam String keyword){
		
		List<InsuranceTypeDto> customInsuranceTypeDtos = this.insruanceTypeService.searchInsuranceTypeByKeyword(keyword);
	
		return new ResponseEntity<> (customInsuranceTypeDtos, HttpStatus.OK);
	}*/
	
}
