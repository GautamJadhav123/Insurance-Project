package com.insuranceApp.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insuranceApp.exception.ResourceNotFoundException;
import com.insuranceApp.model.InsuranceType;
import com.insuranceApp.model.Policy;
import com.insuranceApp.model.PolicyFactor;
import com.insuranceApp.model.User;
import com.insuranceApp.payload.PolicyRequestPayload;
import com.insuranceApp.payload.PolicyResponsePayload;
import com.insuranceApp.repository.InsuranceTypeRepository;
import com.insuranceApp.repository.PolicyRepository;
import com.insuranceApp.repository.UserRepository;
import com.insuranceApp.service.PolicyService;
import com.insuranceApp.utils.coverageandpremium.CoverageAndPremiumAmount;
import com.insuranceApp.utils.coverageandpremium.CoverageAndPremiumMethods;


@Service
public class PolicyServiceImpl implements PolicyService{
	
	@Autowired
	private PolicyRepository policyRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private InsuranceTypeRepository insuranceTypeRepository;
	
	
	@Autowired
	private ModelMapper modelMapper;

	//returns PolicyResponsePayload object containing the policy info along with the dynamically calculated coverage and premium amounts for the available term plans under the selected policy.
	@Override
	public PolicyResponsePayload getPolicyById(Integer policyId, Integer userId) {
			
		Policy policy =	this.policyRepository.findById(policyId).orElseThrow(()-> 
																			 new ResourceNotFoundException("Policy", "Policy Id", policyId));
		//retrieves the various factors to calculate coverage and premium amounts.
		PolicyFactor pFactors = policy.getPolicyFactor();	
		
		User user = this.userRepository.findById(userId).orElseThrow(()-> 
																	 new ResourceNotFoundException("User", "User Id", userId));
		
		//calculates the coverage and premium amounts for the available term plans and stores into the list.
		List<CoverageAndPremiumAmount> coverageAndPremiumsTermPlans = CoverageAndPremiumMethods.calculateCoverageAndPremiumAmounts(pFactors, user);
		
		PolicyResponsePayload finalPolicy = this.modelMapper.map(policy, PolicyResponsePayload.class);
		
		//set the CoverageAndPremiumAmounts field explicitly.
		finalPolicy.setCoverageAndPremiumAmounts(coverageAndPremiumsTermPlans);
		
		return finalPolicy;
	}

	//creates a record in database for new policy and associates to a particular insurance type.
	@Override
	public PolicyRequestPayload createPolicy(PolicyRequestPayload policyRequestPayload, Integer insuranceTypeId) {
		
		InsuranceType insuranceType = this.insuranceTypeRepository.findById(insuranceTypeId).orElseThrow(()->
																										 new ResourceNotFoundException("Insurance Type", "Insurance Type Id", insuranceTypeId));
	    
		Policy policy = this.modelMapper.map(policyRequestPayload, Policy.class);
		
		//set the insurance type field explicitly.
		policy.setInsuranceType(insuranceType);	
		
		Policy policyACreated = this.policyRepository.save(policy);		
		
		return this.modelMapper.map(policyACreated, PolicyRequestPayload.class);
	}

	//deletes the record in database based on policyId
	@Override
	public void deletePolicy(Integer policyId) {
		
		Policy policy = this.policyRepository.findById(policyId).orElseThrow(()->
																			 new ResourceNotFoundException ("Policy", "Policy Id", policyId));
		this.policyRepository.delete(policy);
	}

	//returns the list of PolicyResponsePayload objects containing the policies under the selected insurance type.
	@Override
	public List<PolicyResponsePayload> getAllPoliciesUnderInsuranceType(Integer insuranceId, Integer userId) {
	
		InsuranceType insuranceType = this.insuranceTypeRepository.findById(insuranceId).orElseThrow(()->
																									 new ResourceNotFoundException("Insurance Type", "Insurance Type Id", insuranceId));
		User user = this.userRepository.findById(userId).orElseThrow(()-> 
		 															 new ResourceNotFoundException("User", "User Id", userId));
		
		List<Policy> policies = this.policyRepository.findByInsuranceType(insuranceType);
		
		//traverse through each policy and calculate the coverage and premium amounts dynamically and return to a list of PolicyResponsePayload objects.
		List<PolicyResponsePayload> responsePolicies = policies.stream().map((policy)->{
			
			PolicyFactor pFactors = policy.getPolicyFactor();
			List<CoverageAndPremiumAmount> coverageAndPremiumsTermPlans = CoverageAndPremiumMethods.calculateCoverageAndPremiumAmounts(pFactors, user);		
			PolicyResponsePayload finalPolicy = this.modelMapper.map(policy, PolicyResponsePayload.class);		
			finalPolicy.setCoverageAndPremiumAmounts(coverageAndPremiumsTermPlans);	
			return finalPolicy;})
			.collect(Collectors.toList());
	
		return responsePolicies;
	}	
}
