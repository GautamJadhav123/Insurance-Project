package com.insuranceApp.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table; 




@Entity
@Table (name = "insurance_types")
public class InsuranceType {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer insuranceTypeId;
	
	private String insuranceTypeName;
	
	private String insuranceTypeDescription;
	
	
	@ElementCollection
    @CollectionTable(name = "premium_types",
                     joinColumns = @JoinColumn(name = "insurance_type_id"))
    @Column(name = "type")
	private List<String> premiumType;

	
	@OneToMany (mappedBy = "insuranceType")
	private List<Policy> policies;


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


	public List<Policy> getPolicies() {
		return policies;
	}


	public void setPolicies(List<Policy> policies) {
		this.policies = policies;
	}


	public InsuranceType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}


//SELECT * FROM insurance_type WHERE 'low' IN (SELECT unnest(type) FROM insurance_types);
//fetch query