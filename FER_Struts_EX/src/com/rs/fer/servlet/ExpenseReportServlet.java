package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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

@WebServlet("/expenseReport")
public class ExpenseReportServlet extends HttpServlet {

	FERService ferservice = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		ferservice = new FERServiceImpl();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		String nextPath = null;

		int id = Integer.parseInt(session.getAttribute("id").toString());

		String expense_type = request.getParameter("expenseType");
		String fromDate = request.getParameter("fromDate");
		String toDate = request.getParameter("toDate");

		List<Expense> expenses = ferservice.expenseReport(expense_type, fromDate, toDate);
		PrintWriter out = response.getWriter();

		HtmlUtil.displayHeaderAndLeftFrame(request, response, out, session.getAttribute("username").toString());
		if (expenses != null && !expenses.isEmpty()) {

			out.println("<table align='center' border='1' height='75px width='50px' cellpadding='1px'>");
			out.println("<tr>");
			out.println("<th>Expense Type</th>");
			out.println("<th>Date</th>");
			out.println("<th>Price</th>");
			out.println("<th>No. Of Items</th>");
			out.println("<th>Total</th>");
			out.println("<th>By Whom</th>");
			out.println("<th>Action</th>");
			out.println("</tr>");
		

			for (Expense expense : expenses) {

				out.println("<tr>");
				out.println("<td><input type='text' name='expenseType' value='" + expense.getExpense_type() + "'></td>");
				out.println("<td><input type='date' name='date'  value='" + expense.getDate() + "'></td>");
				out.println("<td><input type='number' name='price' value='" + expense.getPrice() + "'></td>");
				out.println("<td><input type='number' name='noOfItems' value='" + expense.getNo_of_items() + "'></td>");
				out.println("<td><input type='number' name='total' value='" + expense.getTotal() + "'></td>");
				out.println("<td><input type='text' name='byWhom' value='" + expense.getBy_whom() + "'></td>");
				out.println("</tr>");
			}

			out.println("</table>");	

		}
		HtmlUtil.displayFooter(request, response);

	}

	@Override
	public void destroy() {
		ferservice = null;
	}
}
