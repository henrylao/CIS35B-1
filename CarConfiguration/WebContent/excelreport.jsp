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
<table>
	<%
	response.setContentType("application/vnd.ms-excel");
	response.setHeader("Content-Disposition", "inline; filename=car.xls");
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
