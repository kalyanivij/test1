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
import com.rs.fer.util.HtmlUtil;

@WebServlet("/displayReset")
public class DisplayResetServlet extends HttpServlet {



	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out= response.getWriter();
			HtmlUtil.displayHeaderAndLeftFrame(request, response, out, "");

		
request.getRequestDispatcher("ResetPassword.html").include(request, response);

			HtmlUtil.displayFooter(request, response);
	}
	
	}
