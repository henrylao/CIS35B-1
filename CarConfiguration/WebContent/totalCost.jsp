<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pricing</title>
</head>
<body BGCOLOR="#FDF5E6">
<h1 ALIGN="CENTER" >Price</h1>
<%@ page import="javax.servlet.http.HttpSession" 
	import="model.Automobile" 
	import="java.io.ObjectOutputStream" 
	import="java.io.ObjectInputStream" %>

request.
<%
Automobile car = (Automobile) request.getAttribute("car");
ObjectOutputStream o = (ObjectOutputStream) session.getAttribute("out");
ObjectInputStream i = (ObjectInputStream) session.getAttribute("in");
%>

<%
int j =2;
int in = 0;
int k = in + j;
//out.println("value of k is "+k);
%>
<br>

The value of k is: <%=k %>??
</body>
</html>