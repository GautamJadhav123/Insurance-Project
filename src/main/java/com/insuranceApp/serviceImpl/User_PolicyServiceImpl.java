package com.insuranceApp.serviceImpl;

import java.util.List;  

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.insuranceApp.exception.InvalidChoiceException;
import com.insuranceApp.exception.ResourceNotFoundException;
import com.insuranceApp.model.Policy;
import com.insuranceApp.model.User;
import com.insuranceApp.model.User_Policy;
import com.insuranceApp.payload.DueDatesAndEmiPremiumResponsePayload;
import com.insuranceApp.payload.PolicyDto;
import com.insuranceApp.payload.UserResponsePayload;
import com.insuranceApp.payload.User_PolicyDto;
import com.insuranceApp.repository.PolicyRepository;
import com.insuranceApp.repository.UserRepository;
import com.insuranceApp.repository.User_PolicyRepository;
import com.insuranceApp.service.DueDatesAndEmiPremiumService;
import com.insuranceApp.service.User_PolicyService;
import com.insuranceApp.utils.datesandemi.ModesOfPaying;


@Service
public class User_PolicyServiceImpl implements User_PolicyService {

	
	@Autowired
	private User_PolicyRepository user_PolicyRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PolicyRepository policyRepository;
	
	@Autowired
	private DueDatesAndEmiPremiumService dueDatesAndEmiPremiumService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	//returns User_PolicyDto object containing the information about user, policy and relevant info about policy's dates, installments and so on.
	@Transactional
	@Override
	public User_PolicyDto buyPolicyToUser(Integer userId, Integer policyId, String termPlan, String paymentPeriod) {
		
		User user = this.userRepository.findById(userId).orElseThrow(()->
																	 new ResourceNotFoundException("User", "User Id", userId));
		Policy policy = this.policyRepository.findById(policyId).orElseThrow(()->
																			 new ResourceNotFoundException("Policy", "Policy Id", policyId));
		
		//calculate the EMI details and other dates info using the dueDatesAndEmiPremiumService service method.
		DueDatesAndEmiPremiumResponsePayload data = this.dueDatesAndEmiPremiumService.getPremiumEmiDetails(userId, policyId, termPlan);
		
		//retrieve the available paying periods and select the required option. 
		List<ModesOfPaying> modesOfPaying = data.getModesOfPaying();
		
		ModesOfPaying selectedPeriod = null;
		for (ModesOfPaying obj : modesOfPaying) { 
			if (obj.getPeriod().equalsIgnoreCase(paymentPeriod)) {
				selectedPeriod = obj;
			break;
			}
		}		
		
		if (selectedPeriod == null) {
			throw new InvalidChoiceException("Payment Period", paymentPeriod, policy.getPolicyName()); 
		}
		
		//create a user_policy object to save in database and set all the fields.
		User_Policy userPolicy = new User_Policy();
		userPolicy.setUser(user);
		userPolicy.setPolicy(policy);
		userPolicy.setPurchaseDate(data.getPurchaseDate());
		userPolicy.setCommencementDate(data.getCommencementDate());
		userPolicy.setMaturityDate(data.getMaturityDate());
		userPolicy.setSelectedCoverageAmount(data.getCoverageAmount());
		userPolicy.setSelectedPremiumAmount(data.getPremiumAmount());
		userPolicy.setSelectedTermPlan(data.getSelectedTermPlan());
		userPolicy.setSelectedPeriod(selectedPeriod.getPeriod());
		userPolicy.setEmiAmount(selectedPeriod.getEmiAmount());
		userPolicy.setDueDate(selectedPeriod.getDueDate());
	
		//save User_Policy object in database
		User_Policy savedUserPolicy = this.user_PolicyRepository.save(userPolicy);
		
		UserResponsePayload userResponse = this.modelMapper.map(user, UserResponsePayload.class);
		PolicyDto policyDto = this.modelMapper.map(policy, PolicyDto.class);
		
		//create User_PolicyDto object to return
		User_PolicyDto userPolicyDto = this.modelMapper.map(savedUserPolicy, User_PolicyDto.class);
		
		//explicitly set the UserResponsePayload and PolicyDto to prepare User_PolicyDto object.
		userPolicyDto.setUserResponsePayload(userResponse);
		userPolicyDto.setPolicyDto(policyDto);
		
		return userPolicyDto;
	}

}
