package com.insuranceApp.payload;

import java.time.LocalDate;
import java.util.List;

import com.insuranceApp.utils.datesandemi.ModesOfPaying;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel (description = "holds the details for various dates and paying terms options for the selected plan under a particular policy")
public class DueDatesAndEmiPremiumResponsePayload {
	
	@ApiModelProperty (notes = "purchase date is assumed to be current date")
	private LocalDate purchaseDate;
	
	@ApiModelProperty (notes = "1st date of the next month from the purchase date")
	private LocalDate commencementDate;
	
	@ApiModelProperty (notes = "specific maturity date calculated from the purchase date")
	private LocalDate maturityDate;
	
	@ApiModelProperty (notes = "paying options available for the selected term plan")
	private List<ModesOfPaying> modesOfPaying;
	
	
	private Double premiumAmount;
	
	private Double coverageAmount;
	
	private String selectedTermPlan;

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

	public List<ModesOfPaying> getModesOfPaying() {
		return modesOfPaying;
	}

	public void setModesOfPaying(List<ModesOfPaying> modesOfPaying) {
		this.modesOfPaying = modesOfPaying;
	}

	public Double getPremiumAmount() {
		return premiumAmount;
	}

	public void setPremiumAmount(Double premiumAmount) {
		this.premiumAmount = premiumAmount;
	}

	public Double getCoverageAmount() {
		return coverageAmount;
	}

	public void setCoverageAmount(Double coverageAmount) {
		this.coverageAmount = coverageAmount;
	}

	public String getSelectedTermPlan() {
		return selectedTermPlan;
	}

	public void setSelectedTermPlan(String selectedTermPlan) {
		this.selectedTermPlan = selectedTermPlan;
	}

	public DueDatesAndEmiPremiumResponsePayload(LocalDate purchaseDate, LocalDate commencementDate,
			LocalDate maturityDate, List<ModesOfPaying> modesOfPaying, Double premiumAmount, Double coverageAmount,
			String selectedTermPlan) {
		super();
		this.purchaseDate = purchaseDate;
		this.commencementDate = commencementDate;
		this.maturityDate = maturityDate;
		this.modesOfPaying = modesOfPaying;
		this.premiumAmount = premiumAmount;
		this.coverageAmount = coverageAmount;
		this.selectedTermPlan = selectedTermPlan;
	}
	
	
	

}
