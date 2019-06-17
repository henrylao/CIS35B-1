<HTML>
    <HEAD>
        <TITLE>Reading Password Controls</TITLE>
    </HEAD>

    <BODY>
	<H1>Using Password Controls</H1>
        <FORM ACTION="formAction.jsp" METHOD="POST">
            Please enter your password:
            <INPUT TYPE="PASSWORD" NAME="password">
            <BR>
            <INPUT TYPE="SUBMIT" VALUE="Submit">
        </FORM>
	<%! private int count = 1; %>
	<%
		if(count++ == 1)
			out.println("Pl. use the form.");
		else
		{
	%>
        	<H1>Reading Password Controls</H1>
	        <% 
        		if(request.getParameter("password").equals("Open Sesame")) 
			{
		            out.println("You're in!"); 
        		} 
		        else 
			{
            		   out.println("I don't think so!"); 
        		} 
		}
        %>
    </BODY>
</HTML>