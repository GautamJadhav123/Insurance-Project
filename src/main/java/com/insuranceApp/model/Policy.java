package com.insuranceApp.model;

import javax.persistence.CascadeType; 
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name= "Policys")
public class Policy {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer policyId;
	
	private String policyName;
	
	private Integer policyNo;
		
	private String policyStatus;
	
	@ManyToOne 
	@JoinColumn (name = "insuranceType_Id")
	private InsuranceType insuranceType;
	
	@OneToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn (name = "policy_factor")
	private PolicyFactor policyFactor;


	public PolicyFactor getPolicyFactor() {
		return policyFactor;
	}


	public void setPolicyFactor(PolicyFactor policyFactor) {
		this.policyFactor = policyFactor;
	}


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

	public InsuranceType getInsuranceType() {
		return insuranceType;
	}


	public void setInsuranceType(InsuranceType insuranceType) {
		this.insuranceType = insuranceType;
	}


	public Policy() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
