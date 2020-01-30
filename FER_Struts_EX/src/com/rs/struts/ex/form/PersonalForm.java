package com.rs.struts.ex.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

public class PersonalForm extends ValidatorForm {
	private String firstName;
	private String middleName;
	private String lastName;
	private String emailId;
	private String mobileNumber;
	private String Address1;
	private String Address2;
	private String Street;
	private String City;
	private String State;
	private int Pincode;

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

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress1() {
		return Address1;
	}

	public void setAddress1(String Address1) {
		this.Address1 = Address1;
	}

	public String getAddress2() {
		return Address2;
	}

	public void setAddress2(String Address2) {
		this.Address2 = Address2;
	}

	public String getStreet() {
		return Street;
	}

	public void setStreet(String Street) {
		this.Street = Street;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String City) {
		this.City = City;
	}

	public String getState() {
		return State;
	}

	public void setState(String State) {
		this.State = State;
	}

	public int getPincode() {
		return Pincode;
	}

	public void setPincode(int Pincode) {
		this.Pincode = Pincode;
	}

}
