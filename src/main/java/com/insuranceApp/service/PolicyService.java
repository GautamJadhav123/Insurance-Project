package com.insuranceApp.service;

import java.util.List;

import com.insuranceApp.payload.PolicyRequestPayload;
import com.insuranceApp.payload.PolicyResponsePayload;

public interface PolicyService {
	
	public PolicyResponsePayload getPolicyById(Integer policyId, Integer userId);
	
	public PolicyRequestPayload createPolicy (PolicyRequestPayload policyRequestPayload, Integer insuranceTypeId);
	
	public void deletePolicy (Integer policyId);
	
	public List<PolicyResponsePayload> getAllPoliciesUnderInsuranceType(Integer insuranceId, Integer userId);
	

}
