<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%!
	%>
	<h3>Hello...</h3>
	<br>
	<form action="/Calculator1/search" method="get">
		Search Key : <input name="key" type="text" /> <input type="submit"
			value="SEARCH" />
	</form>
	<div style="max-height: 200px; background-color: red;">
		Search Results Are :
		<%
		List<String> result = new ArrayList<>();
		String key = request.getParameter("key");
		if (!(key == null || key.trim().equalsIgnoreCase(""))) {
			result.add("123");
			result.add("1234");
			result.add("12345");
			result.add("123456");
			result.add("1234567");
		}
		result.forEach(System.out::println);
	%>
		<%
			for (String k : result) {
				out.println(k);
			}
		%>
	</div>
	<br>
</body>
</html>