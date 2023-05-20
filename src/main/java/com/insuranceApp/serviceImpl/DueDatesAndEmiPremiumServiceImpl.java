package com.insuranceApp.serviceImpl;

import java.util.Map; 
import java.util.List;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insuranceApp.exception.InvalidChoiceException;
import com.insuranceApp.exception.ResourceNotFoundException;
import com.insuranceApp.model.DueDatesAndEmiPremium;
import com.insuranceApp.model.Policy;
import com.insuranceApp.model.PolicyFactor;
import com.insuranceApp.model.User;
import com.insuranceApp.payload.DueDatesAndEmiPremiumResponsePayload;
import com.insuranceApp.repository.PolicyRepository;
import com.insuranceApp.repository.UserRepository;
import com.insuranceApp.service.DueDatesAndEmiPremiumService;
import com.insuranceApp.utils.coverageandpremium.CoverageAndPremiumAmount;
import com.insuranceApp.utils.coverageandpremium.CoverageAndPremiumMethods;
import com.insuranceApp.utils.datesandemi.DueDatesAndEmiMethods;


@Service
public class DueDatesAndEmiPremiumServiceImpl implements DueDatesAndEmiPremiumService {
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PolicyRepository policyRepository;

	
	//Calculates the all dates and paying period options for the selected term plan by user under the selected policy.
	@Override
	public DueDatesAndEmiPremiumResponsePayload getPremiumEmiDetails(Integer userId, Integer policyId, String termPlan) {
		
		User user = this.userRepository.findById(userId).orElseThrow(()->
																	 new ResourceNotFoundException("User", "User Id", userId));
		Policy policy = this.policyRepository.findById(policyId).orElseThrow(()->
																			 new ResourceNotFoundException("Policy", "Policy Id", policyId));
	
		// selects the pair of coverage and premium amount for the selected term plan under the selected policy.
		CoverageAndPremiumAmount selectedTermPlanAmounts = CoverageAndPremiumMethods.selectCoverageAndPremiumAmounts(policy.getPolicyFactor(),
																													 user,
																													 termPlan);
		// retrieves the paying period options for the selected term plan.
		PolicyFactor pFactor = policy.getPolicyFactor();
		Map<String,String[]> paymentModes = pFactor.getPaymentModes();
		
		List<String> periods = null;
		for (Map.Entry<String, String[]> entry : paymentModes.entrySet()) {
			if (entry.getKey().equalsIgnoreCase(termPlan))
				periods = Arrays.asList(entry.getValue());
		}
		
		if (periods == null) {
			throw new InvalidChoiceException("Term Plan", termPlan, policy.getPolicyName());
		}
		
		//calculates the dates and paying period options for the selected term plan under the selected policy.
		DueDatesAndEmiPremium dueDatesAndEmiPremium = DueDatesAndEmiMethods.calculateDates(selectedTermPlanAmounts.getTermPlan(),
																						   selectedTermPlanAmounts.getPremiumAmount(),
																						   periods);
		
		return new DueDatesAndEmiPremiumResponsePayload(dueDatesAndEmiPremium.getPurchaseDate(),
														dueDatesAndEmiPremium.getCommencementDate(),
														dueDatesAndEmiPremium.getMaturityDate(),
														dueDatesAndEmiPremium.getModesOfPaying(),
														selectedTermPlanAmounts.getPremiumAmount(),
														selectedTermPlanAmounts.getCoverageAmount(),
														selectedTermPlanAmounts.getTermPlan());
	}

}
