package com.rs.struts.eg.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;
import com.rs.struts.ex.form.AddExpenseForm;
import com.rs.struts.ex.form.ResetForm;

public class ResetAction extends DispatchAction {

	public ActionForward display(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		return mapping.findForward("resetPassword");

	}

	public ActionForward reset(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		FERService ferservice = new FERServiceImpl();
		ResetForm resetForm = (ResetForm) form;
		int id = Integer.parseInt(request.getParameter("id"));
		String currentPassword = request.getParameter("currentPassword");
		String newPassword = request.getParameter("newPassword");
		String confirmPassword = request.getParameter("confirmPassword");

		boolean isReset = ferservice.resetPassword(id, currentPassword, newPassword);

		session.setAttribute("status", (isReset ? "password changed successfully" : "password is not changed"));

		return mapping.findForward("status");

	}

}