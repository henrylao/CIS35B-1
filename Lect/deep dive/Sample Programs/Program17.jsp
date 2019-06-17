//Redirecting Pages with Response.Redirect
//redirect.jsp
<%
   String name = (String)request.getParameter("name");
   String choice = (String)request.getParameter("choice");
%>
<%
   if((name == null) || (name.length() == 0)) {
      response.sendRedirect("errorName.html");
   }
   else if(choice.equals("NONE")) {
      response.sendRedirect("errorChoice.html");     
   }
%>

<h4> Hello <%= name %></h4>
<%
   out.println("Glad you could join us. Here's the news you requested..");
%>
<hr>

<%
   pageContext.include(choice + ".html");
%>

//Several html files to redirect to
//errorChoice.html
<html>

<head><title>No Choice</title></head>

<body>

<h3> No topic was selected. </h3>

Would you like to <a href="index.html"> start again? </a>

</body>
</html>

//Several html files to redirect to
//errorName.html

<html>
<body>

    <h3> A valid name is required before entering the news service. </h3>
    
    Would you like to <a href="index.html"> start again? </a>

</body>
</html>
