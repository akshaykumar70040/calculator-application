package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SeventhServlet")
public class SeventhServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
	response.setContentType("text/html");
// TODO Auto-generated method stub
response.getWriter().append("Served at: ").append(request.getContextPath());

PrintWriter writer = response.getWriter();

String aa = request.getParameter("num1");
String bb = request.getParameter("num2");
int a = Integer.valueOf(aa);
int b = Integer.valueOf(bb);
String action = request.getParameter("action");

int L = a * b;
int t = 0;
while (b != 0) {
t = b;
b = a % b;
a = t;
}
try {
if (action.equals("hcf"))
writer.append("HCF of two numbers" + a);
if (action.equals("lcm")) {
int z = L / a;
writer.append("LCM of two numbers" + z);
}
} catch (Exception e) {
}
writer.write(" Go Back to index page  : <a href=\"/Calculator\" >click here</a>");}}
