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

@WebServlet("/displayPersonalContact")
public class DisplayPersonalContactServlet extends HttpServlet {

	FERService ferservice = null;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		ferservice = new FERServiceImpl();

		int userId = Integer.parseInt(session.getAttribute("id").toString());
		User user= (User) session.getAttribute("user");

		//User user = ferservice.getUser(userId);
		user.setFirst_name(request.getParameter("firstName"));
		user.setMiddle_name(request.getParameter("middleName"));
		user.setLast_name(request.getParameter("lastName"));
		session.setAttribute("user", user);

		PrintWriter out = response.getWriter();

		HtmlUtil.displayHeaderAndLeftFrame(request, response, out, session.getAttribute("username").toString());

		out.println("<table align='center' border='1' height='400px' width='250px'>");
		out.println("<tr>");
		out.println("<td colspan='2' align='center'>Update ContactInfo</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Email Id</td>");
		out.println("<td><input type='email' name='emailId'  value='" + user.getEmail() + "'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Mobile Number</td>");
		out.println("<td><input type='text' name='mobileNumber' value='" + user.getMobile_number() + "'></td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td align='center' colspan='2'>");
		out.println(
				"<td align='center' colspan='2'><input type='button' value='Next'  onClick=\"javascript:submitForm('displaypersonalAddress')\"> &nbsp; &nbsp;</td>");

		out.println("</tr>");
		out.println("</table>");

		HtmlUtil.displayFooter(request, response);
	}

	@Override
	public void destroy() {
		ferservice = null;
	}
}
