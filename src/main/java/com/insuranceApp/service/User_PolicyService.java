package com.insuranceApp.service;

import com.insuranceApp.payload.User_PolicyDto;

public interface User_PolicyService {
	
	public User_PolicyDto buyPolicyToUser(Integer userId, Integer policyId, String termPlan, String paymentPeriod);

}
