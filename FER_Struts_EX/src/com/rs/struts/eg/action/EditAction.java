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
import com.rs.struts.ex.form.EditForm;

public class EditAction extends DispatchAction {

	FERService ferservice = new FERServiceImpl();
	
	public ActionForward dropDown(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		int id = Integer.parseInt(session.getAttribute("id").toString());
		List<Expense> expenses = ferservice.getExpenses(id);
		session.setAttribute("expenses", expenses);
		return mapping.findForward("editDropDown");

	}
	

	public ActionForward display(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		int expenseId = Integer.parseInt(request.getParameter("expenseId").toString());

		Expense expense = ferservice.getExpense(expenseId);
		session.setAttribute("expense", expense);
		
		return mapping.findForward("editExpense");
	}

	public ActionForward edit(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		
		HttpSession session = request.getSession();
		EditForm editForm = (EditForm) form;
		
		Expense expense = (Expense) session.getAttribute("expense");
		
		expense.setExpense_type(editForm.getExpenseType());
		expense.setDate(editForm.getDate());
		expense.setPrice(editForm.getPrice());
		expense.setNo_of_items(editForm.getNoOfItems());
		expense.setTotal(editForm.getTotal());
		expense.setBy_whom(editForm.getByWhom());
		
		boolean isEditExpense = ferservice.editExpense(expense);

		
		session.setAttribute("status", (isEditExpense ? "Expense edited successsully" : "Failed to edit expense"));
		return mapping.findForward("status");

	}

}