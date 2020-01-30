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

@WebServlet("/reset")
public class ResetServlet extends HttpServlet {

	FERService ferservice = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		ferservice = new FERServiceImpl();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();
		String nextPath = null;

		int id = Integer.parseInt(session.getAttribute("Id").toString());
		String currentPassword = request.getParameter("currentPassword");
		String newPassword = request.getParameter("newPassword");
		String confirmPassword = request.getParameter("confirmPassword");

		boolean isReset = ferservice.resetPassword(id, currentPassword, newPassword);

		HtmlUtil.displayHeaderAndLeftFrame(request, response, out, "");
		if (isReset) {

			out.println("password changed successfully");

		} else {
			out.println("password is not changed");

		}
		HtmlUtil.displayFooter(request, response);
		request.getRequestDispatcher(nextPath).include(request, response);

	}

	@Override
	public void destroy() {
		ferservice = null;
	}
}
