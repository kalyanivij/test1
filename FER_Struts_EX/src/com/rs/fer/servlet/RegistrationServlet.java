package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {

	FERService ferservice = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		ferservice = new FERServiceImpl();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = new User();
		user.setFirst_name(request.getParameter("firstName"));
		user.setMiddle_name(request.getParameter("middleName"));
		user.setLast_name(request.getParameter("lastName"));
		user.setEmail(request.getParameter("emailId"));
		user.setUsername(request.getParameter("userName"));
		user.setPassword(request.getParameter("password"));
		user.setMobile_number(request.getParameter("mobileNumber"));

		boolean isRegister = ferservice.registeration(user);
		PrintWriter out = response.getWriter();
		String nextPath = null;
		if (isRegister) {
			out.println("Registered successfully. Login to continue");
			nextPath = "Login.html";
		} else {
			out.println("Registeration failed, Please try again...");
			nextPath = "Registeration.html";
		}
		request.getRequestDispatcher(nextPath).include(request, response);

	}

	@Override
	public void destroy() {
		ferservice = null;
	}
}
