<HTML>
<HEAD>
<TITLE>Computing Speed</TITLE>
<LINK REL=STYLESHEET
      HREF="JSP-Styles.css"
      TYPE="text/css">
</HEAD>

<BODY>

<%@ page errorPage="Error.jsp" %>

<TABLE BORDER=5 ALIGN="CENTER">
  <TR><TH CLASS="TITLE">
      Computing Speed</TABLE>

<%! 
// Note lack of try/catch for NumberFormatException if
// value is null or malformed.

private double toDouble(String value) {
  return(Double.valueOf(value).doubleValue());
}
%>

<% 
double furlongs = toDouble(request.getParameter("furlongs")); 
double fortnights = toDouble(request.getParameter("fortnights"));
double speed = furlongs/fortnights;
%>

<UL>
  <LI>Distance: <%= furlongs %> furlongs.
  <LI>Time: <%= fortnights %> fortnights.
  <LI>Speed: <%= speed %> furlongs per fortnight.
</UL>

</BODY>
</HTML>
