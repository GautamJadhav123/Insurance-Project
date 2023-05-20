package com.insuranceApp.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insuranceApp.exception.ResourceNotFoundException;
import com.insuranceApp.model.InsuranceType;
import com.insuranceApp.payload.InsuranceTypeDto;
import com.insuranceApp.repository.InsuranceTypeRepository;
import com.insuranceApp.service.InsuranceTypeService;

@Service
public class InsuranceTypeServiceImpl implements InsuranceTypeService {
	
	@Autowired
	private InsuranceTypeRepository insuranceTypeRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	//creates a record n database for new insurance type and returns the insuranceTypeDto object.
	@Override
	public InsuranceTypeDto createInsuranceType(InsuranceTypeDto insuranceTypeDto) {
		
		InsuranceType insuranceType = this.modelMapper.map(insuranceTypeDto, InsuranceType.class);
		InsuranceType savedInsuranceType = this.insuranceTypeRepository.save(insuranceType);
		
		return this.modelMapper.map(savedInsuranceType, InsuranceTypeDto.class);
	}          
           
	// deletes a particular insurance type based on insuranceTypeId.
	@Override
	public void deleteInsuranceType(Integer isuranceTypeId) {
		
		InsuranceType isuranceType = this.insuranceTypeRepository.findById(isuranceTypeId).orElseThrow(()->
																									   new ResourceNotFoundException("Insurance Type", "Insurance Type Id", isuranceTypeId));
		this.insuranceTypeRepository.delete(isuranceType);
	}

	//returns the list of insuranceTypeDtos from the database.
	@Override
	public List<InsuranceTypeDto> getAllInsuranceTypes() {
		
		List<InsuranceType> allInsuranceTypes = this.insuranceTypeRepository.findAll();
		
		List<InsuranceTypeDto> allInsuranceTypeDtos = allInsuranceTypes
													                   .stream()
													                   .map(s->this.modelMapper.map(s, InsuranceTypeDto.class))
													                   .collect(Collectors.toList());	
		return allInsuranceTypeDtos;
	}

	//returns the list insuranceTypeDtos based on keyword search from the database.
/*	@Override
	public List<InsuranceTypeDto> searchInsuranceTypeByKeyword(String keyword) {
		
		//use custom query generating method from  the repository.
		List<InsuranceType> customInsuranceType = this.insuranceTypeRepository.findByKeywordContaining(keyword);
		
		List<InsuranceTypeDto> customInsuranceTypeDtos = customInsuranceType.stream().map((s)->
																						   this.modelMapper.map(s, InsuranceTypeDto.class))
																						   .collect(Collectors.toList());

		return customInsuranceTypeDtos;
	}*/

}
