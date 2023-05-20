package com.insuranceApp.utils.coverageandpremium;

import java.util.List;   

import java.util.ArrayList;

import com.insuranceApp.model.PolicyFactor;
import com.insuranceApp.model.User;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class CoverageAndPremiumMethods {
	
	//returns a list containing objects of CoverageAndPremiumAmount storing coverage and premium amounts for a term plan under the selected policy.
	public static List<CoverageAndPremiumAmount> calculateCoverageAndPremiumAmounts (PolicyFactor pFactors, User user){
		
		
		List<CoverageAndPremiumAmount> coverageAndPremiumAmounts = new ArrayList<>();
		
		int userAge = user.getAge();
		Integer userIncome = user.getAnnualIncome();
		String occupation = user.getOccupation();
		
		//retrieve the age factors and occupation risk factors.
		Map<String, Double[]> factors = pFactors.getCoverageAndPremiumFactors();
		List<Double> ageFactor = pFactors.getAgeFactor();
		List<Double> occupationRiskFactor = pFactors.getOccupationRiskFactor();
		
		//choose appropriate age factor based on  the condition check.
		Double ageFactorValue = 1d ;
		if (userAge >= 20)
			ageFactorValue = ageFactor.get(0);
		else if (userAge <= 35)
			ageFactorValue = ageFactor.get(1);
		else
			ageFactorValue = ageFactor.get(2);
		 
		//choose appropriate occupation risk factor based on the condition check.
		Double occupationRiskFactorValue = 1d;
		if (occupation.equalsIgnoreCase("low"))
			occupationRiskFactorValue = occupationRiskFactor.get(0);
		else if (occupation.equalsIgnoreCase("medium"))
			occupationRiskFactorValue = occupationRiskFactor.get(1);
		else if (occupation.equalsIgnoreCase("high"))
			occupationRiskFactorValue = occupationRiskFactor.get(2);
		
		//traverse through each term plan, calculating premium and coverage amounts using the selected age & occupation risk factors.
		for (Map.Entry<String, Double[]> entry : factors.entrySet()) {
			String termPlan = entry.getKey();
			Double[] factorsArray = entry.getValue();
		   
			//array retrieved from the database contains premium factor at 0th index and coverage factor at 1st index.
			Double premiumFactor = factorsArray[0];
			Double coverageFactor = factorsArray[1];
			
			Double premiumAmount = userIncome * premiumFactor * ageFactorValue * occupationRiskFactorValue;
			Double coverageAmount = premiumAmount * coverageFactor * ageFactorValue * occupationRiskFactorValue;
			
			//add CoverageAndPremiumAmount object storing coverage and premium amounts with term plan to list 
			coverageAndPremiumAmounts.add(new CoverageAndPremiumAmount(coverageAmount, premiumAmount, termPlan));
		}	
		
		return coverageAndPremiumAmounts;
	}
	
	//selects the object containing the coverage and premium amount for the selected term plan, from the list returned by calculateCoverageAndPremiumAmounts (PolicyFactor pFactors, User user).
	public static CoverageAndPremiumAmount selectCoverageAndPremiumAmounts(PolicyFactor pFactors, User user, String termPlan) {
		
		CoverageAndPremiumAmount result = null;
		
		List<CoverageAndPremiumAmount> coverageAndPremiumAmounts = CoverageAndPremiumMethods.calculateCoverageAndPremiumAmounts(pFactors, user);
		for (CoverageAndPremiumAmount object : coverageAndPremiumAmounts) {
			if (object.getTermPlan().equalsIgnoreCase(termPlan)) {
				result = object;
			break;
			}
		}
		return result;
	}
}
