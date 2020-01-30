package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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

@WebServlet("/displayDeleteExpense")
public class DisplayDeleteExpenseServlet extends HttpServlet {

	FERService ferservice = null;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ferservice = new FERServiceImpl();

		HttpSession session = request.getSession();

		PrintWriter out = response.getWriter();
		HtmlUtil.displayHeaderAndLeftFrame(request, response, out, session.getAttribute("username").toString());

		int id = Integer.parseInt(session.getAttribute("id").toString());
		List<Expense> expenses = ferservice.getExpenses(id);

		out.println("SelectExpense:<select name='expenseId'>");
		if(expenses!=null && !expenses.isEmpty()) {
			int value = 0;
			String desc = null;
			for(Expense expense: expenses) {
				value = expense.getId();
				desc = expense.getExpense_type()+", "+expense.getDate()+", "+expense.getTotal();
				
				out.println("<option value='"+value+"'>"+desc+"</option>");
			}
		}
		out.println("</select><br><br>");
		out.println("<input type='button' value='Delete' onClick=\"javascript:submitForm('deleteExpense')\"> &nbsp; &nbsp;");
		HtmlUtil.displayFooter(request, response);
	}

}
