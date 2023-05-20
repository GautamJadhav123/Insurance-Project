package com.insuranceApp.utils.datesandemi;

import java.time.LocalDate; 
import java.util.List;

import org.springframework.stereotype.Component;

import com.insuranceApp.model.DueDatesAndEmiPremium;

import java.util.ArrayList;


@Component
public class DueDatesAndEmiMethods {
	
	public static List<ModesOfPaying> calculateDueDatesAndEmiPremium (LocalDate purchaseDate, Double premiumAmount, List<String> periods, String termPlan) {
		
		List<ModesOfPaying> list = new ArrayList<>();
		
		LocalDate dueDate= null;
		Double yearlyAmount = 0d;
		
		if (termPlan.equalsIgnoreCase("1year"))
			yearlyAmount = premiumAmount;
		else if (termPlan.equalsIgnoreCase("15year"))
			yearlyAmount = premiumAmount/15;
		else if (termPlan.equalsIgnoreCase("25year"))
			yearlyAmount = premiumAmount/25;
		else if (termPlan.equalsIgnoreCase("4month"))
			yearlyAmount = premiumAmount;
		else if (termPlan.equalsIgnoreCase("8month"))
			yearlyAmount = premiumAmount;
		
		Double emi = 0d;
		
		for (String period : periods) {
			if (period.equalsIgnoreCase("monthly")) {
				emi = yearlyAmount/12;
				dueDate = purchaseDate.plusMonths(1).withDayOfMonth(28);
				}
			else if (period.equalsIgnoreCase("quaterly")) {
				emi = yearlyAmount/3;
				dueDate = purchaseDate.plusMonths(3).withDayOfMonth(28);
			}
			else if (period.equalsIgnoreCase("yearly")) {
				emi = yearlyAmount;
				dueDate = purchaseDate.plusMonths(12).withDayOfMonth(28);
			}
			else {
				emi = yearlyAmount;
				dueDate = purchaseDate.plusMonths(1).withDayOfMonth(28);
			}			
			list.add(new ModesOfPaying(period, emi, dueDate));
		}
		
		return list;
	}
	
	public static DueDatesAndEmiPremium calculateDates(String termPlan, Double premium, List<String> periodsOfPayment) {
		
		int number = Integer.parseInt(termPlan.replaceAll("[^0-9]", ""));
		String plan = termPlan.replaceAll("[0-9]", "");
		
		LocalDate purchaseDate = LocalDate.now();
		LocalDate commencementDate = purchaseDate.plusMonths(1).withDayOfMonth(1);
		
		LocalDate maturityDate = null;
		
		if (plan.equalsIgnoreCase("month"))
			maturityDate = commencementDate.plusMonths(number);
		else if (plan.equalsIgnoreCase("year"))
			maturityDate = commencementDate.plusYears(number);

		List<ModesOfPaying> periodsOptions = DueDatesAndEmiMethods.calculateDueDatesAndEmiPremium(purchaseDate, premium, periodsOfPayment, termPlan);
		
		return new DueDatesAndEmiPremium (purchaseDate, commencementDate, maturityDate, periodsOptions);
	}

}
