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

public class AddExpenseAction extends DispatchAction {

	public ActionForward display(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		return mapping.findForward("addExpense");

	}

	public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		Expense expense = new Expense();
		FERService ferservice = new FERServiceImpl();
		AddExpenseForm expenseForm = (AddExpenseForm) form;
		int id= (int) session.getAttribute("id");
		
		expense.setExpense_type(expenseForm.getExpenseType());
		expense.setDate(expenseForm.getDate());
		expense.setPrice(expenseForm.getPrice());
		expense.setNo_of_items(expenseForm.getNoOfItems());
		expense.setTotal(expenseForm.getTotal());
		expense.setBy_whom(expenseForm.getByWhom());
		expense.setUserid(id);

		boolean isAddExpense = ferservice.addExpense(expense);

		session.setAttribute("status", (isAddExpense ? "Expense added successsully" : "Failed to add expense"));
		return mapping.findForward("status");

	}

}