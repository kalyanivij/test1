package com.rs.struts.examples.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.validator.ValidatorForm;

public class LoginForm extends ValidatorForm {

	private String username;
	private String password;

	public String getUsername() {
		System.out.println("getUsername()");
		return username;
	}

	public void setUsername(String username) {
		System.out.println("setUsername()");
		this.username = username;
	}

	public String getPassword() {
		System.out.println("getPassword()");
		return password;
	}

	public void setPassword(String password) {
		System.out.println("setPassword()");
		this.password = password;
	}

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		System.out.println("reset()");
		this.username = "Please enter username";
	}

	/*
	 * @Override public ActionErrors validate(ActionMapping mapping,
	 * HttpServletRequest request) { System.out.println("validate()");
	 * 
	 * ActionErrors errors = new ActionErrors();
	 * 
	 * if(null == getUsername() || "".equals(getUsername().trim())) {
	 * errors.add("username", new ActionMessage("error.username.required")); }
	 * if(null == getPassword() || "".equals(getPassword().trim())) {
	 * errors.add("password", new ActionMessage("error.password.required")); }
	 * 
	 * return errors; }
	 */}
