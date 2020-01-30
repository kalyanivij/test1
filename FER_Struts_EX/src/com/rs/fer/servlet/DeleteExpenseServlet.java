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

@WebServlet("/deleteExpense")
public class DeleteExpenseServlet extends HttpServlet {

	FERService ferservice = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		ferservice = new FERServiceImpl();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		int expenseId = Integer.parseInt(request.getParameter("expenseId").toString());
		PrintWriter out = response.getWriter();

		boolean isDeleteExpense = ferservice.deleteExpense(expenseId);

		HtmlUtil.displayHeaderAndLeftFrame(request, response, out, session.getAttribute("username").toString());

		if (isDeleteExpense) {
			out.println("Expense deleted successfully");
		} else {
			out.println("Failed to delete expense...");
		}
		HtmlUtil.displayFooter(request, response);
	}

	@Override
	public void destroy() {
		ferservice = null;
	}
}
