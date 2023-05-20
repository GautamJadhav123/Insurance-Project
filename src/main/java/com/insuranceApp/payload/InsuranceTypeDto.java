package com.insuranceApp.payload;

import java.util.List;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel; 



@ApiModel (description = "holds the information for a insurance type under which various policies can be associated")
public class InsuranceTypeDto {
	
	
	private Integer insuranceTypeId;
	
	@NotNull (message = "Insurance name can not be empty")
	private String insuranceTypeName;
	
	@NotNull (message = "Description can not be empty")
	@Size (min = 10, message = "Description must be more than 10 characters")
	private String insuranceTypeDescription;
	
	@NotNull (message = "must contain at least any one term plan to support")
	@Column (name = "termPlans")
	private List<String> premiumType;
	
	//private List<PolicyRequestPayload> policies;

	public Integer getInsuranceTypeId() {
		return insuranceTypeId;
	}

	public void setInsuranceTypeId(Integer insuranceTypeId) {
		this.insuranceTypeId = insuranceTypeId;
	}

	public String getInsuranceTypeName() {
		return insuranceTypeName;
	}

	public void setInsuranceTypeName(String insuranceTypeName) {
		this.insuranceTypeName = insuranceTypeName;
	}

	public String getInsuranceTypeDescription() {
		return insuranceTypeDescription;
	}

	public void setInsuranceTypeDescription(String insuranceTypeDescription) {
		this.insuranceTypeDescription = insuranceTypeDescription;
	}

	public List<String> getPremiumType() {
		return premiumType;
	}

	public void setPremiumType(List<String> premiumType) {
		this.premiumType = premiumType;
	}

/*	public List<PolicyRequestPayload> getPolicies() {
		return policies;
	}

	public void setPolicies(List<PolicyRequestPayload> policies) {
		this.policies = policies;
	}*/

	public InsuranceTypeDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
