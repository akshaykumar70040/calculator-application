package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class thirdservlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		writer.println("hello in servlet 3");

		String valuesA = req.getParameter("credits");
		String[] values1 = valuesA.split(",");
		String valuesB = req.getParameter("debits");
		String[] values2 = valuesB.split(",");
		int credit = 0;
		int debit = 0;
		int total;
		try {
			for (String a : values1) {
				int val = Integer.valueOf(a.trim());
				credit += val;
			}
		} catch (Exception e) {

		}
		try {
			for (String b : values2) {
				int val1 = Integer.valueOf(b.trim());
				debit += val1;
			}
		} catch (Exception ee) {

		}
		total = credit - debit;
		writer.println("total sum is" + total);
		

		writer.write("<a href=\"/Calculator1\" > click here</a>");
	}}

