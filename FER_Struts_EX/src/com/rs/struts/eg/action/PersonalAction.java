package com.rs.struts.eg.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.rs.fer.bean.Expense;
import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;
import com.rs.struts.ex.form.AddExpenseForm;

public class PersonalAction extends DispatchAction {
	FERService ferservice = new FERServiceImpl();

	public ActionForward name(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		int id = Integer.parseInt(session.getAttribute("id").toString());
		User user = ferservice.getUser(id);
		session.setAttribute("user", user);

		return mapping.findForward("updateName");

	}

	public ActionForward contact(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		int userId = Integer.parseInt(session.getAttribute("id").toString());
		User user = (User) session.getAttribute("user");
		user.setFirst_name(request.getParameter("firstName"));
		user.setMiddle_name(request.getParameter("middleName"));
		user.setLast_name(request.getParameter("lastName"));
		session.setAttribute("user", user);

		return mapping.findForward("updateContact");
	}

	public ActionForward address(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		int id = Integer.parseInt(session.getAttribute("id").toString());
		User user = (User) session.getAttribute("user");
		user.setEmail(request.getParameter("EmailId"));
		user.setMobile_number(request.getParameter("MobileNumber"));

		return mapping.findForward("updateAddress");
	}

	public ActionForward review(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		int id = Integer.parseInt(session.getAttribute("id").toString());
		User user = (User) session.getAttribute("user");
		user.getAddress().setLine_1(request.getParameter("Address1"));
		user.getAddress().setLine_2(request.getParameter("Address2"));
		user.getAddress().setStreet(request.getParameter("Street"));
		user.getAddress().setCity(request.getParameter("City"));
		user.getAddress().setState(request.getParameter("State"));
		user.getAddress().setPincode(Integer.parseInt(request.getParameter("Pincode")));
		session.setAttribute("user", user);

		return mapping.findForward("updateReview");
	}

	public ActionForward status(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		boolean isUpdate = ferservice.updateUser(user);
		session.setAttribute("status",
				(isUpdate ? "Information updated successsully" : "Failed to update information"));

		return mapping.findForward("status");

	}

}