package com.insuranceApp.repository;

import java.util.List; 

import org.springframework.data.jpa.repository.JpaRepository; 

import com.insuranceApp.model.InsuranceType;

public interface InsuranceTypeRepository extends JpaRepository <InsuranceType, Integer> {

	//List<InsuranceType> findByKeywordContaining (String keyword);

}
