package com.peeyoosh.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns = "/login.do")
@WebServlet(urlPatterns = "/oldloginwithservlet.do")
public class LoginServlet extends HttpServlet {

	private UserAuthService mUserAuthService = new UserAuthService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/views/Login.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String password = request.getParameter("password");
		if (mUserAuthService.isUserValid(name, password)) {
			request.setAttribute("username", name);
			request.getRequestDispatcher("/WEB-INF/views/Welcome.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMessage", "Invalid User Credentials");
			request.getRequestDispatcher("/WEB-INF/views/Login.jsp").forward(request, response);
		}

	}
}
