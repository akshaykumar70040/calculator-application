package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String pass = req.getParameter("pass");
		
		if(username.equals("abc")&&pass.equals("123")) {
			HttpSession session = req.getSession(true);
			session.setAttribute("user", "abc");
			resp.sendRedirect("http://localhost:8080/Calculator1/");
		} else {
			resp.sendRedirect("http://localhost:8080/Calculator1/login.html");			
		}
		
		
	}
}
