package com.insuranceApp.utils.coverageandpremium;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel (description = "holds the calculated coverage and premium amounts based on the term plan selected by the user under particular policy.")
public class CoverageAndPremiumAmount {
	

	private Double coverageAmount;


	private Double premiumAmount;
	
	@ApiModelProperty (notes = "specific term plan available under the selected policy will be choosen")
	private String termPlan;

	public Double getCoverageAmount() {
		return coverageAmount;
	}

	public void setCoverageAmount(Double coverageAmount) {
		this.coverageAmount = coverageAmount;
	}

	public Double getPremiumAmount() {
		return premiumAmount;
	}

	public void setPremiumAmount(Double premiumAmount) {
		this.premiumAmount = premiumAmount;
	}

	public String getTermPlan() {
		return termPlan;
	}

	public void setTermPlan(String termPlan) {
		this.termPlan = termPlan;
	}

	public CoverageAndPremiumAmount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CoverageAndPremiumAmount(Double coverageAmount, Double premiumAmount, String termPlan) {
		super();
		this.coverageAmount = coverageAmount;
		this.premiumAmount = premiumAmount;
		this.termPlan = termPlan;
	}

	@Override
	public String toString() {
		return "CoverageAndPremiumAmount [coverageAmount=" + coverageAmount + ", premiumAmount=" + premiumAmount
				+ ", termPlan=" + termPlan + "]";
	}
	
	
	

}
