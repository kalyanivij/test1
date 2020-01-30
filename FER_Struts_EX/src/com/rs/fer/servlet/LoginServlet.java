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

import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;
import com.rs.fer.util.HtmlUtil;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	FERService ferservice = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		ferservice = new FERServiceImpl();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("Username");
		String password = request.getParameter("Password");

		int id = ferservice.login(username, password);

		PrintWriter out = response.getWriter();
		String nextPath = null;

		if (id > 0) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			session.setAttribute("id", id);

			HtmlUtil.displayHeaderAndLeftFrame(request, response, out, username);

			out.println("Welcome to the user:" + username);

			HtmlUtil.displayFooter(request, response);

		} else {
			out.println("Login failed due to incorrect username/password, Please try again...");
			nextPath = "Login.html";
		}
		request.getRequestDispatcher(nextPath).include(request, response);

	}

	@Override
	public void destroy() {
		ferservice = null;
	}
}
