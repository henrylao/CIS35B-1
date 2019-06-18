//setProperty and getProperty tags
<HTML>
<HEAD>
</HEAD>
<BODY>
<%@ page language="java" %>

<jsp:useBean id="counter" scope="session" class="beans.Counter" />

<jsp:setProperty name="counter" property="count" param="count" />
<%

    out.println("Count from scriptlet code : "
      + counter.getCount() + "<BR>");

%>

Count from jsp:getProperty :
  <jsp:getProperty name="counter" property="count" /><BR>

</BODY>
</HTML>

