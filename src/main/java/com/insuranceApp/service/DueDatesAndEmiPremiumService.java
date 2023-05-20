package com.insuranceApp.service;

import com.insuranceApp.payload.DueDatesAndEmiPremiumResponsePayload;

public interface DueDatesAndEmiPremiumService {
	
	public DueDatesAndEmiPremiumResponsePayload getPremiumEmiDetails(Integer userId, Integer policyId, String termPlan);
	

}
