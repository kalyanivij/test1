package com.rs.struts.eg.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;
import com.rs.struts.ex.form.LoginForm;

public class LoginAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		FERService ferservice = new FERServiceImpl();
		HttpSession session = request.getSession();

		LoginForm loginForm = (LoginForm) form;
		int id = ferservice.login(loginForm.getUsername(), loginForm.getPassword());
		session.setAttribute("id", id);
		session.setAttribute("username", loginForm.getUsername());
		return mapping.findForward(id > 0 ? "success" : "failure");

	}

}
