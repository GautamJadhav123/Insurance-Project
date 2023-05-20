package com.insuranceApp.payload;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.insuranceApp.model.PolicyFactor;

import io.swagger.annotations.ApiModel; 


@ApiModel (description = "this class holds the policy details to be used while user buys a policy.")
public class PolicyDto {

	private Integer policyId;
	
	@NotNull (message = "Policy name can not be empty")
	private String policyName;
	
	@NotNull (message = "Policy No. can not be empty")
	@Size (min = 3, message = "Policy No. should be at least 3 characters")
	private Integer policyNo;
		
	@Pattern(regexp = "^(?i)(alive|not-alive)$", message = "Policy status can only be 'alive' or 'not-alive'")
	private String policyStatus;
	
	//private PolicyFactor policyFactor;

	public Integer getPolicyId() {
		return policyId;
	}

	public void setPolicyId(Integer policyId) {
		this.policyId = policyId;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public Integer getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(Integer policyNo) {
		this.policyNo = policyNo;
	}

	public String getPolicyStatus() {
		return policyStatus;
	}

	public void setPolicyStatus(String policyStatus) {
		this.policyStatus = policyStatus;
	}

/*	public PolicyFactor getPolicyFactor() {
		return policyFactor;
	}

	public void setPolicyFactor(PolicyFactor policyFactor) {
		this.policyFactor = policyFactor;
	}*/

	public PolicyDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
