package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;
import com.rs.fer.util.HtmlUtil;

@WebServlet("/editExpense")
public class EditExpenseServlet extends HttpServlet {

	FERService ferservice = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		ferservice = new FERServiceImpl();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Expense expense = (Expense) session.getAttribute("expense");

		PrintWriter out = response.getWriter();
		HtmlUtil.displayHeaderAndLeftFrame(request, response, out, "");

		expense.setExpense_type(request.getParameter("expenseType"));
		expense.setDate(request.getParameter("date"));
		expense.setPrice(Float.parseFloat(request.getParameter("price")));
		expense.setNo_of_items(Integer.parseInt(request.getParameter("noOfItems")));
		expense.setTotal(Float.parseFloat(request.getParameter("total")));
		expense.setBy_whom(request.getParameter("byWhom"));
		
		boolean isEditExpense = ferservice.editExpense(expense);

		if (isEditExpense) {
			out.println("expenses edited Successfully");
		} else {
			out.println("Failed to edit expense...");
		}
		HtmlUtil.displayFooter(request, response);
	}

	@Override
	public void destroy() {
		ferservice = null;
	}
}
