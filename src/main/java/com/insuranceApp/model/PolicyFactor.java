package com.insuranceApp.model;

import java.util.List; 
import java.util.Map;


import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.MapKeyColumn;

import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table (name = "Policy_Factor")
@ApiModel (description = "this table holds the various factors used in calculation of coverage and premium amount values.")
public class PolicyFactor {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer policyFactorId;
	

    @ElementCollection
    @ApiModelProperty (notes = "age factors stored as list in database")
    private List<Double> ageFactor;

    @ElementCollection
    @ApiModelProperty (notes = "occupation risk factors stored as list in database")
    private List<Double> occupationRiskFactor;
    
    
    @ElementCollection
    @CollectionTable(name = "policy_coverage_and_premium_factors",
            		 joinColumns = @JoinColumn(name = "policy_id"))
    @MapKeyColumn(name = "term_plan")
    @Column(name = "coverageAndPremiumFactors")
    @ApiModelProperty (notes = "stores the term plans and corresponding coverage and premium factors as a map in database 'term plan : [premium factor, coverage factor]'")
    private Map<String, Double[]> coverageAndPremiumFactors;
    
    @ElementCollection
    @CollectionTable(name = "policy_termPlan_paymentModes",
            		 joinColumns = @JoinColumn(name = "policy_id"))
    @MapKeyColumn(name = "term_plan")
    @Column(name = "paymentModes")
    @ApiModelProperty (notes = "stores the term plans and corresponding paying period options as a map in database 'term plan : [paying period options]'")
    private Map<String, String[]> paymentModes;
    

	public Integer getPolicyFactorId() {
		return policyFactorId;
	}

	public void setPolicyFactorId(Integer policyFactorId) {
		this.policyFactorId = policyFactorId;
	}


	public List<Double> getAgeFactor() {
		return ageFactor;
	}

	public void setAgeFactor(List<Double> ageFactor) {
		this.ageFactor = ageFactor;
	}

	public List<Double> getOccupationRiskFactor() {
		return occupationRiskFactor;
	}

	public void setOccupationRiskFactor(List<Double> occupationRiskFactor) {
		this.occupationRiskFactor = occupationRiskFactor;
	}

	public Map<String, Double[]> getCoverageAndPremiumFactors() {
		return coverageAndPremiumFactors;
	}

	public void setCoverageAndPremiumFactors(Map<String, Double[]> coverageAndPremiumFactors) {
		this.coverageAndPremiumFactors = coverageAndPremiumFactors;
	}

	public Map<String, String[]> getPaymentModes() {
		return paymentModes;
	}

	public void setPaymentModes(Map<String, String[]> paymentModes) {
		this.paymentModes = paymentModes;
	}  
	
	
    	
}
