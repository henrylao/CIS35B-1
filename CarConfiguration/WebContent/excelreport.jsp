<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>Sample Hello World Example</title>
     </head>
      <%@ page import="javax.servlet.http.HttpSession" 
		import="model.Automobile" 
%>
<%
	Automobile a = (Automobile) session.getAttribute("car");
	for(int m = 0; m < a.getOptionSetSize(); m++) {
		String optionSetName = a.getOptionSetName(m);
		a.setOptionChoice(m, (String) request.getParameter(optionSetName));
	}
%>
<body>
<table cellpadding="1"  cellspacing="1" border="1" bordercolor="gray">
	<tr>
	<%
	response.setContentType("application/vnd.ms-excel");
	response.setHeader("Content-Disposition", "inline; filename=car.xls");
	for(int m = 0; m < a.getOptionSetSize(); m++){
		String optionSetName = a.getOptionSetName(m);%>
	</tr>
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
</body>
</html>