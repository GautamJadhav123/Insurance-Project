package com.insuranceApp.exception;

public class ResourceNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String resourceName;
	String fieldName;
	Integer fieldValue;
	
	public ResourceNotFoundException (String resouceName, String fieldName, Integer fieldValue) {
		super(String.format("%s  not found with %s : %d", resouceName, fieldName, fieldValue));
		this.resourceName = resouceName;
		this.fieldName 	= fieldName;
		this.fieldValue = fieldValue;
	}
	

}
