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

@WebServlet("/displaypersonalAddress")
public class DisplayPersonalAddressServlet extends HttpServlet {

	FERService ferservice = null;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		ferservice = new FERServiceImpl();

		int id = Integer.parseInt(session.getAttribute("id").toString());

		User user = (User)session.getAttribute("user");

		user.setEmail(request.getParameter("EmailId"));
		user.setMobile_number(request.getParameter("MobileNumber"));

		PrintWriter out = response.getWriter();

		HtmlUtil.displayHeaderAndLeftFrame(request, response, out, session.getAttribute("username").toString());

		out.println("<table align='center' border='1' height='400px' width='250px'>");
		out.println("<tr>");
		out.println("<td colspan='2' align='center'>Update Address</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Address 1</td>");
		out.println("<td><input type='text' name='Address1' value= "+ user.getAddress().getLine_1() + "></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Address 2</td>");
		out.println("<td><input type='text' name='Address2' value="+ user.getAddress().getLine_2() +"></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Street(area)</td>");
		out.println("<td><input type='text' name='Street' value=" + user.getAddress().getStreet() +"></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>City</td>");
		out.println("<td><input type='text'name='City' value= " + user.getAddress().getCity() +"></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>State</td>");
		out.println("<td><input type='text'name='State' value="+ user.getAddress().getState() + "></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Pincode</td>");
		out.println("<td><input type='text' name='Pincode' value="+ user.getAddress().getPincode() +"></td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td align='center' colspan='2'>");
		out.println(
				"<input type='button' value='Next'  onClick=\"javascript:submitForm('displayPersonalReview')\"> &nbsp; &nbsp;");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");

		HtmlUtil.displayFooter(request, response);
	}

	@Override
	public void destroy() {
		ferservice = null;
	}
}
