package com.rs.struts.eg.action;

import java.util.List;

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
import com.rs.struts.ex.form.DeleteForm;
import com.rs.struts.ex.form.ResetForm;

public class DeleteAction extends DispatchAction {

	FERService ferservice = new FERServiceImpl();

	public ActionForward dropDown(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		int id = Integer.parseInt(session.getAttribute("id").toString());
		List<Expense> expenses = ferservice.getExpenses(id);
		session.setAttribute("expenses", expenses);

		return mapping.findForward("deleteExpense");

	}

	public ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		DeleteForm deleteForm = (DeleteForm) form;
		int expenseId = Integer.parseInt(request.getParameter("expenseId"));

		boolean isDeleteExpense = ferservice.deleteExpense(expenseId);

		session.setAttribute("status", (isDeleteExpense ? "Expenses deleted successfully" : "Expense is not deleted"));

		return mapping.findForward("status");

	}

}