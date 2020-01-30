package com.rs.struts.ex.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

public class RegistrationForm extends ValidatorForm {
	private String firstName;
	private String middleName;
	private String lastName;
	private String emailId;
	private String username;
	private String password;
	private String mobileNumber;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
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

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.firstName = "Enter First Name";
		this.middleName = "Enter Middle Name";
		this.lastName = "Enter Last Name";
		this.username = "Enter valid username";
		this.mobileNumber = "Enter active Mobile Number";
		this.emailId = "Enter valid EmailId";
	}

}
