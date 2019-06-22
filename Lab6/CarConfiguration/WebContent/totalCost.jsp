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
			import="java.io.ObjectInputStream" 
		%>
		<%
		Automobile a = (Automobile) session.getAttribute("car");
		ObjectOutputStream o = (ObjectOutputStream) session.getAttribute("out");
		ObjectInputStream i = (ObjectInputStream) session.getAttribute("in");
		for(int m = 0; m < a.getOptionSetSize(); m++){
			String optionSetName = a.getOptionSetName(m);
			a.setOptionChoice(m, (String) request.getParameter(optionSetName));
		}
		%>
		<p align=center>Here is what you selected:</p>
		<table border=2 align=center id="tableData">
			<tr bgcolor=FFAD00>
			<tr>
				<td><%=a.getMake()%> <%=a.getModel()%></td>
				<td>Base Price</td>
				<td align=right><%=a.getbaseprice() %></td>
			</tr>
			<%
			
			for(int m = 0; m < a.getOptionSetSize(); m++){
				String optionSetName = a.getOptionSetName(m);%>
				<tr>
					<td><%=optionSetName %></td>
					<td><%=a.getOptionChoiceName(optionSetName) %></td>
					<td align=right><%=a.getOptionChoicePrice(optionSetName) %></td>
				</tr>
			<%
			}
			%>
			<tr>
				<td><strong>Total Cost</strong></td>
				<td></td>
				<td><strong>$<%=a.caulateTotal() %></strong></td>
			</tr>
		</table> 
		<p align="center"><a href="excelreport.jsp">save as excel</a></p>
		<p align="center"><a href="/CarConfiguration/">restart</a></p>
	</body>
</html>