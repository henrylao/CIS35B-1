<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body  BGCOLOR="#FDF5E6">
<h1 ALIGN="CENTER" >Price</h1>
<%!
public int add(int a, int b){
	return a + b;
}
%>
<%
int i = 1;
int j =2;
int k;
k = i + j;
//out.println("value of k is "+k);
%>
<br>
<%
k = add(123,345);
%>
The value of k is: <%=k %>??
</body>
</html>