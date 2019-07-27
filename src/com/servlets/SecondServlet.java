package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		writer.println("hello in servlet 2");

		String values = req.getParameter("args");
		String[] values2 = values.split(",");
		int sum = 0;

		for (String a : values2) {
			try {
				int val = Integer.valueOf(a.trim());
				sum += val;				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

//		int sum = Arrays.asList(req.getParameter("args").split(",")).stream().map(a -> Integer.valueOf(a))
//				.mapToInt(i -> i).sum();
		writer.println("Sum value is : " + sum);
		writer.write("<a href=\"/Calculator1\" > click here</a>");

	}
}
