package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SixthServlet
 */
@WebServlet("/SixthServlet")
public class SixthServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
	response.setContentType("text/html");
// TODO Auto-generated method stub
response.getWriter().append("Served at: ").append(request.getContextPath());
PrintWriter writer = response.getWriter();

String prin = request.getParameter("prin");
String rate = request.getParameter("rate");
String num = request.getParameter("no");

// int n=Integer.valueOf(num);

double EMI = 0;

double r = (Double.parseDouble(rate) / (12 * 100));
double pr = Double.parseDouble(prin) * r;
double rn = (1 + r);
double rn1 = Math.pow(rn, Double.parseDouble(num));
double rn2 = (Math.pow(rn, (Double.parseDouble(num)))) - 1;

try {
EMI = (pr * rn1) / rn2;
// writer.append("You have to pay "+EMI," for" +n ,"months to repay the entire
// loan amount");

writer.append("EMI per monthly is" + EMI);

double pay = EMI * Double.parseDouble(num);
double interest = Double.parseDouble(prin) - pay;

writer.append("Interest towards the loan to be paid" + interest);

writer.write("<a href=\"/Calculator\" > click here</a>");
} catch (Exception e) {
}

}

}