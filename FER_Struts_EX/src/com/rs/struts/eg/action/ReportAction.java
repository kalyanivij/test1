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

public class ReportAction extends DispatchAction {

	public ActionForward display(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		return mapping.findForward("expenseReport");

	}

	public ActionForward report(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		Expense expense = new Expense();
		FERService ferservice = new FERServiceImpl();
		int id = Integer.parseInt(session.getAttribute("id").toString());
		String expense_type = request.getParameter("expenseType");
		String fromDate = request.getParameter("fromDate");
		String toDate = request.getParameter("toDate");
		List<Expense> expenses = ferservice.expenseReport(expense_type, fromDate, toDate);

		
		session.setAttribute("expenses", expenses);
		
		session.setAttribute("status", (expenses != null && !expenses.isEmpty()? "success" : "Failed to fetch expenses"));
		return mapping.findForward((expenses != null && !expenses.isEmpty()) ? "success" : "status");

	}

}