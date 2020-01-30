package com.rs.struts.ex.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

public class LoginForm extends ValidatorForm {
	private String username;
	private String password;

	public String getUsername() {
		System.out.println("LoginForm.getUsername()");
		return username;
	}

	public void setUsername(String username) {
		System.out.println("LoginForm.setUsername()");
		this.username = username;
	}

	public String getPassword() {
		System.out.println("LoginForm.getPassword()");
		return password;
	}

	public void setPassword(String password) {
		System.out.println("LoginForm.setPassword()");
		this.password = password;
	}

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		System.out.println("LoginForm.reset()");
		this.username = "Enter valid user name";
	}

	/*@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		System.out.println("LoginForm.validate()");
		ActionErrors errors = new ActionErrors();

		if (this.username == null || this.username.trim().equals("")) {
			errors.add("username", new ActionMessage("error.username.required"));
		}
			if (this.password == null || this.password.trim().equals("")) {
				errors.add("password", new ActionMessage("error.password.required"));
			}
		
		return errors;

	}*/
}
