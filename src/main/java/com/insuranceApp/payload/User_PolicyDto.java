package com.insuranceApp.payload;

import java.time.LocalDate;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel (description = "this class holds the information to be returned to the user after creating a successful record for policy bought by the user.")
public class User_PolicyDto {
	
	
	private Integer userPolicyId;
	
	private String selectedTermPlan;
	
	private Double selectedCoverageAmount;
	
	private Double selectedPremiumAmount;
	
	private String selectedPeriod;
	
	private Double emiAmount;
	
	private LocalDate purchaseDate;
	
	private LocalDate commencementDate;
	
	private LocalDate maturityDate;
	
	private LocalDate dueDate;
	
	@ApiModelProperty (notes = "user who bought the policy")
	private UserResponsePayload userResponsePayload;
	
	@ApiModelProperty (notes = "policy bought by the user")
	private PolicyDto policyDto;

	public Integer getUserPolicyId() {
		return userPolicyId;
	}

	public void setUserPolicyId(Integer userPolicyId) {
		this.userPolicyId = userPolicyId;
	}

	public String getSelectedTermPlan() {
		return selectedTermPlan;
	}

	public void setSelectedTermPlan(String selectedTermPlan) {
		this.selectedTermPlan = selectedTermPlan;
	}

	public Double getSelectedCoverageAmount() {
		return selectedCoverageAmount;
	}

	public void setSelectedCoverageAmount(Double selectedCoverageAmount) {
		this.selectedCoverageAmount = selectedCoverageAmount;
	}

	public Double getSelectedPremiumAmount() {
		return selectedPremiumAmount;
	}

	public void setSelectedPremiumAmount(Double selectedPremiumAmount) {
		this.selectedPremiumAmount = selectedPremiumAmount;
	}

	public String getSelectedPeriod() {
		return selectedPeriod;
	}

	public void setSelectedPeriod(String selectedPeriod) {
		this.selectedPeriod = selectedPeriod;
	}

	public Double getEmiAmount() {
		return emiAmount;
	}

	public void setEmiAmount(Double emiAmount) {
		this.emiAmount = emiAmount;
	}

	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public LocalDate getCommencementDate() {
		return commencementDate;
	}

	public void setCommencementDate(LocalDate commencementDate) {
		this.commencementDate = commencementDate;
	}

	public LocalDate getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(LocalDate maturityDate) {
		this.maturityDate = maturityDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public UserResponsePayload getUserResponsePayload() {
		return userResponsePayload;
	}

	public void setUserResponsePayload(UserResponsePayload userResponsePayload) {
		this.userResponsePayload = userResponsePayload;
	}

	public PolicyDto getPolicyDto() {
		return policyDto;
	}

	public void setPolicyDto(PolicyDto policyDto) {
		this.policyDto = policyDto;
	}

	public User_PolicyDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
