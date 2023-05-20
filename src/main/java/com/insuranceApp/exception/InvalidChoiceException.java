package com.insuranceApp.exception;

public class InvalidChoiceException extends RuntimeException{
	
	//invalid choice, 'input' : 'choice'  is not available under 'policyName'
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String input;
	
	String choice;
	
	String policyName;

	public InvalidChoiceException(String input, String choice, String policyName) {
		super(String.format("invalid choice, %s : %s  is not available under %s", input, choice, policyName));
		this.input = input;
		this.choice = choice;
		this.policyName = policyName;
	}
	
	
	

}
