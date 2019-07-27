package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FirstServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		resp.setContentType("text/html");
		HttpSession session = req.getSession(false);
		if (session != null) {
			System.out.println("Session is not null");
			String user = (String) session.getAttribute("user");
			System.out.println("First servlet got a request");
			if (user != null)
				writer.append("Hello " + user);
			writer.append(" Now time is : " + new Date());
			writer.append("<br>");
			writer.append("Sum value is :");
			String num1 = req.getParameter("num1");
			String num2 = req.getParameter("num2");
			String action = req.getParameter("action");

			int res = 0;
			if (action.equals("add"))
				res = Integer.valueOf(num1) + Integer.valueOf(num2);
			if (action.equals("sub"))
				res = Integer.valueOf(num1) - Integer.valueOf(num2);
			if (action.equals("multi"))
				res = Integer.valueOf(num1) * Integer.valueOf(num2);
			if (action.equals("divide"))
				res = Integer.valueOf(num1) / Integer.valueOf(num2);
			if (action.equals("mod"))
				res = Integer.valueOf(num1) % Integer.valueOf(num2);

			writer.append(String.valueOf(res));
			Cookie[] cookies = req.getCookies();
			if (cookies != null && cookies.length != 0) {
				for (Cookie ck : cookies) {
					writer.write("<br>");
					writer.write(ck.getName() + " : " + ck.getValue());
				}
			}
			System.out.println("Setting the cookie value time to : " + new Date().toString());
			Random rand = new Random();
			// Obtain a number between [0 - 49].
			int n = rand.nextInt(50);
			Cookie c = new Cookie("time" + n, URLEncoder.encode(new Date().toString(), "UTF-8"));
			c.setMaxAge(60);
			resp.addCookie(c);
		} else {
			System.out.println("Session is null");
			resp.sendRedirect("http://localhost:8080/Calculator1/login.html");
		}

		writer.write("Go Back to index page  : <a href=\"/Calculator1\" >click here</a>");
		writer.write("Logout  : <a href=\"/Calculator1/logout\" >Logout</a>");
		writer.write("Namin config is : " + getServletConfig().getInitParameter("name"));
	}
}
