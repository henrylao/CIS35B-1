<HTML>
<HEAD>
<TITLE>JSP Declarations</TITLE>

</HEAD>

<BODY>
<H1>JSP Declarations</H1>

<%! private int accessCount = 0; %>
<H2>Accesses to page since server reboot: 
<%= ++accessCount %></H2>

</BODY>
</HTML>

