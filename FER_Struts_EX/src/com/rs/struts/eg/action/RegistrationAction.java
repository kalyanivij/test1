package com.rs.struts.eg.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;
import com.rs.struts.ex.form.LoginForm;
import com.rs.struts.ex.form.RegistrationForm;

public class RegistrationAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		FERService ferservice = new FERServiceImpl();
		HttpSession session = request.getSession();

		RegistrationForm registrationForm = (RegistrationForm) form;
		User user = new User();

		user.setFirst_name(registrationForm.getFirstName());
		user.setMiddle_name(registrationForm.getMiddleName());
		user.setLast_name(registrationForm.getLastName());
		user.setEmail(registrationForm.getEmailId());
		user.setUsername(registrationForm.getUsername());
		user.setPassword(registrationForm.getPassword());
		user.setMobile_number(registrationForm.getMobileNumber());
		
		boolean isRegister = ferservice.registeration(user);
		return mapping.findForward(isRegister ? "success" : "failure");

	}

}
