package com.insuranceApp.payload;

import java.util.List; 

import com.insuranceApp.model.InsuranceType;

import com.insuranceApp.utils.coverageandpremium.CoverageAndPremiumAmount;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel (description = "this class holds the policy details to be shown to the user when he selcts a particular option to view policies")
public class PolicyResponsePayload  {
	

	private Integer policyId;
	
	private String policyName;
	
	private Integer policyNo;
		
	private String policyStatus;
	
//	private InsuranceTypeDto insuranceTypeDto;

    @ApiModelProperty (notes = "stores the various term plans and repective coverage and premium amounts calculated dynamically using the user information")
	private List<CoverageAndPremiumAmount> coverageAndPremiumAmounts;
	

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

/*	public InsuranceTypeDto getInsuranceTypeDto() {
		return insuranceTypeDto;
	}

	public void setInsuranceTypeDto(InsuranceTypeDto insuranceType) {
		this.insuranceTypeDto = insuranceType;
	}*/

	public List<CoverageAndPremiumAmount> getCoverageAndPremiumAmounts() {
		return coverageAndPremiumAmounts;
	}

	public void setCoverageAndPremiumAmounts(List<CoverageAndPremiumAmount> coverageAndPremiumAmounts) {
		this.coverageAndPremiumAmounts = coverageAndPremiumAmounts;
	}


	public PolicyResponsePayload() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

}
