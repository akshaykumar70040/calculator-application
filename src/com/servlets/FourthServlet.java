package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FourthServlet
 */
@WebServlet("/FourthServlet")
public class FourthServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
	response.setContentType("text/html");
// TODO Auto-generated method stub
// response.getWriter().append("Served at: ").append(request.getContextPath());

PrintWriter writer = response.getWriter();
writer.println("Welcome to 4 th servlet");

String values = request.getParameter("num");
int num1 = Integer.valueOf(values);
int n = num1 / 2;
int flag = 0;
try {
for (;;) {
if (num1 == 1 || num1 == 0) {
flag = 1;
break;
}
if (num1 % 2 == 0) {
flag = 1;
break;
}
for (int i = 3; i <= n; i++) {
if (num1 % i == 0) {
flag = 1;
break;
}
}
}
if (flag == 0)
writer.append(num1 + "--Is a Prime Number");
else
writer.append(num1 + "--Not a prime number");
}catch(Exception e) {}

writer.write("<a href=\"/Calculator\" > click here</a>");

}

}