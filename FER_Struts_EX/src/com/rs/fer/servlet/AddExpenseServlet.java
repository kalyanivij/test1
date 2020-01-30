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
import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;
import com.rs.fer.util.HtmlUtil;

@WebServlet("/addExpense")
public class AddExpenseServlet extends HttpServlet {

	FERService ferservice = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		ferservice = new FERServiceImpl();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();

		Expense expense = new Expense();
		

		expense.setExpense_type(request.getParameter("expense Type"));
		expense.setDate(request.getParameter("date"));
		expense.setPrice(Float.parseFloat(request.getParameter("price")));
		expense.setNo_of_items(Integer.parseInt(request.getParameter("noOfItems")));
		expense.setTotal(Float.parseFloat(request.getParameter("total")));
		expense.setBy_whom(request.getParameter("byWhom"));
		expense.setUserid(Integer.parseInt(session.getAttribute("id").toString()));

		boolean isAddExpense = ferservice.addExpense(expense);
		
		HtmlUtil.displayHeaderAndLeftFrame(request, response, out, session.getAttribute("username").toString());
		if (isAddExpense) {
			out.println("Expense added successfully");
		} else {
			out.println("Failed to add expense...");
		}
		HtmlUtil.displayFooter(request, response);
	}

	@Override
	public void destroy() {
		ferservice = null;
	}
}
