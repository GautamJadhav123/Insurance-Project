package com.insuranceApp.service;

import java.util.List;

import com.insuranceApp.payload.InsuranceTypeDto;

public interface InsuranceTypeService {
	
	public InsuranceTypeDto createInsuranceType(InsuranceTypeDto insuranceTypeDto);
	
	public void deleteInsuranceType (Integer isuranceTypeId);
	
	public List<InsuranceTypeDto> getAllInsuranceTypes();

	//public List<InsuranceTypeDto> searchInsuranceTypeByKeyword(String keyword);

}
