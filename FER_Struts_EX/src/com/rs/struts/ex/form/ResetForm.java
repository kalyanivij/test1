package com.rs.struts.ex.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

public class ResetForm extends ValidatorForm {
	private int id;
	private String currentPassword;
	private String newPassword;
	private String confirmPassword;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}

	public String getCurrentPassword() {
		return currentPassword;
	}

	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.currentPassword = "Enter your current password";
		this.newPassword = "Enter your new password";
		this.confirmPassword = "Confirm your new password";
	}

}
