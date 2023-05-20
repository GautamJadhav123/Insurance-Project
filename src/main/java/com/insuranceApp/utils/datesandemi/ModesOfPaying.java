package com.insuranceApp.utils.datesandemi;

import java.time.LocalDate;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel (description = "holds the various paying periods options under term plan for a policy")
public class ModesOfPaying {
	
	@ApiModelProperty (notes = "specific paying period option")
	private String period;
	
	@ApiModelProperty (notes = "emi amount calculated based on the paying period option")
	private Double emiAmount;
	
	@ApiModelProperty (notes = "due date for the emi to be paid specific to paying period option")
	private LocalDate dueDate;

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public Double getEmiAmount() {
		return emiAmount;
	}

	public void setEmiAmount(Double emiAmount) {
		this.emiAmount = emiAmount;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public ModesOfPaying(String period, Double emi, LocalDate dueDate) {
		super();
		this.period = period;
		this.emiAmount = emi;
		this.dueDate = dueDate;
	}

	@Override
	public String toString() {
		return "ModesOfPaying [period=" + period + ", emiAmount=" + emiAmount + ", dueDate=" + dueDate + "]";
	}
	
	
	

}
