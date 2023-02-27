<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.techpalle.util.SccessPage" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<%
	SccessPage spJsp = (SccessPage)request.getAttribute("sucessDetails");
	%>
	
	<header>
		<h1><%= spJsp.h1 %></h1>
	</header>
	
		<p><%= spJsp.p %></p>
	
	<footer>
		<h3><%= spJsp.c %></h3>
	</footer>
</body>
</html>