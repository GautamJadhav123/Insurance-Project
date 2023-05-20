package com.insuranceApp.model;

import java.time.LocalDate;  


import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;


@Entity
@Table (name = "user_policy")
public class User_Policy {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
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
	
	@ManyToOne 
	@JoinColumn (name = "user_Id")
	private User user;
	
	@ManyToOne
	@JoinColumn (name = "policy_Id")
	private Policy policy;

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	public User_Policy() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
