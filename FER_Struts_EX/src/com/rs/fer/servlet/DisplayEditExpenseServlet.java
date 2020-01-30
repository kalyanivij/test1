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

@WebServlet("/displayEditExpense")
public class DisplayEditExpenseServlet extends HttpServlet {

	FERService ferservice = null;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ferservice = new FERServiceImpl();

		HttpSession session = request.getSession();

		PrintWriter out = response.getWriter();
		HtmlUtil.displayHeaderAndLeftFrame(request, response, out, session.getAttribute("username").toString());

		int expenseId = Integer.parseInt(request.getParameter("expenseId").toString());

		
		Expense expense = ferservice.getExpense(expenseId);
		session.setAttribute("expense", expense);
		
		out.println("<table align='center' border='1' height='400px' width='250px'>");
		out.println("<tr>");
		out.println("<td colspan='2' align='center'>Edit Expense</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Expense Type</td>");
		out.println("<td><input type='text' name='expenseType' value='"+expense.getExpense_type()+"'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Date</td>");
		out.println("<td><input type='text' name='date'  value='"+expense.getDate()+"'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Price</td>");
		out.println("<td><input type='number' name='price'  value='"+expense.getPrice()+"'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>No. Of Items</td>");
		out.println("<td><input type='number' name='noOfItems'  value='"+expense.getNo_of_items()+"'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Total</td>");
		out.println("<td><input type='number' name='total'  value='"+expense.getTotal()+"'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>By Whom</td>");
		out.println("<td><input type='text' name='byWhom'  value='"+expense.getBy_whom()+"'></td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td align='center' colspan='2'><input type='button' value='Edit Expense'  onClick=\"javascript:submitForm('editExpense')\"> &nbsp; &nbsp;</td>");
	
		out.println("</tr>");
		out.println("</table>");
		
		
		HtmlUtil.displayFooter(request, response);
	}

}
