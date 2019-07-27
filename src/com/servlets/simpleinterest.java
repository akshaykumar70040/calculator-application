package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class simpleinterest  extends HttpServlet{
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	PrintWriter writer= resp.getWriter();
	writer.print("simple interest");
	
	String p=req.getParameter("principalamount");
	String t=req.getParameter("timeperiod");
	String r=req.getParameter("rate");
	int si=0;
	si=(Integer.valueOf(p) + Integer.valueOf(t) + Integer.valueOf(r))/100;
	writer.append("interest rate is"+ si);
	
	writer.write("Go Back to index page : <a href=\"/Calculator1\" >click here</a>");
	
}}