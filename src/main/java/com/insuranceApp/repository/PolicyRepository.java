package com.insuranceApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insuranceApp.model.InsuranceType;
import com.insuranceApp.model.Policy;

public interface PolicyRepository extends JpaRepository <Policy, Integer> {
	
	List<Policy> findByInsuranceType(InsuranceType insuranceType);

}
