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

@WebServlet("/displayPersonalStatus")
public class DisplayPersonalReviewStatusServlet extends HttpServlet {

	FERService ferservice = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		ferservice = new FERServiceImpl();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		int updateUser = Integer.parseInt(session.getAttribute("id").toString());

		User user = (User) session.getAttribute("user");
		session.setAttribute("user", user);

		PrintWriter out = response.getWriter();

		HtmlUtil.displayHeaderAndLeftFrame(request, response, out, session.getAttribute("username").toString());

		boolean isUpdate = ferservice.updateUser(user);

		if (isUpdate) {

			out.println("Updated successfully");

		} else {
			out.println("Update is not successful");

		}
		HtmlUtil.displayFooter(request, response);

	}

	@Override
	public void destroy() {
		ferservice = null;
	}
}
