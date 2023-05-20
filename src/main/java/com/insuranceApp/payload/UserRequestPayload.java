package com.insuranceApp.payload;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
public class UserRequestPayload {
	
	
	private Integer userId;
	
	@NotNull (message = "First Name can not empty")
	private String firstName;
	
	@NotNull (message = "Last Name can not empty")
	private String lastName;
	
	@Positive (message = "Sorry, Age can only be positive")
	private int age;
	
	@Pattern(regexp = "^(?i)(malr|female)$", message = "Gender can either be 'male' or 'female'")
	private String gender;
	
	@Email (message = "Please, provide a valid email address")
	private String email;
	
	@NotNull (message = "UserName can not empty")
	private String username;
	
	@NotNull (message = "Password can not empty")
	private String password;
	
	@Positive (message = "Annaul Income can not negative or zero ")
	@Min (value = 1, message = "Annual Income can not be negative or zero")
	private Integer annualIncome;
	
	@Pattern(regexp = "^(?i)(low|medium|high)$", message = "please provide occupation as either - 'low', 'medium' or 'high'")
	private String occupation;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(Integer annualIncome) {
		this.annualIncome = annualIncome;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public UserRequestPayload() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
