//Cookies
/* -----Working with Cookies
Small bit of Textual information sent to the browser by the WebServer.
Advantages 
	1. Identify a user during an E-Commerce Session
	2. Avoid Username and password for a session - if already logged in
	3. Customization of site visit - like in my.yahoo.com - portal allowing customization of content
	4. Focused Advertising - Based on Search done - display the ads for the given context
Disadvantages
	1. Search for particular topics is remembered inside a cookie
	2. Health Sensitive information can be shared between different sites. Leads to Email Spamming.

Because of the disadvantages - people turn off cookies usage in the browser.
As a Servlet Programmer, be careful not to use cookies for sensitive information.

Cookie API
Create a cookie
	new Cookie(name, value)
	Following characters are not allowed: [](),"/?@:;

Setting additional attributes - 
	cookie.setXxx() - applies to outgoing cookie(server to client).

Inserting the cookie into response header
	response.addCookie(cookie)
	
Reading incoming cookies 
	request.getCookies - returns an array of cookie objects which can later be traversed for usage.

Adding comment with a cookie
	Public String getComment()
	public void setComment(String comment)
	used for information about the cookie.

getting and setting domain for the cookie
	Public String getDomain()
	public void setDomain(String domainpattern)
	Normally the browser will return cookies to exact same host. This method can be used to instruct the browser 	to return them to other hosts within the same domain. For eg cookie.setDomain(".database.com") would send cookies to singh.database.com or oracle.database.com etc.
	
setting the age of cookies
	Public String getMaxAge()
	public void setMaxAge(int lifetime)
	This allow the programmer to set the time in seconds before the cookie expires. 
	A negative value indicates that the cookie last through the end of session.
	A 0 value indicates the browser to delete the cookie.
	A longlivedcookie can be set to leave the cookie inside the browser for a week, month or year - by specifying a large int value.

Setting Cookie name
	Public String getName()
	public void setName(String cookieName)
	This set the name of the cookie.
	Name is typically supplied in cookie constructor. getName is used to 	traverse through the list array of 
	cookie objects returned by getCookies.

Setting/Getting path to which the cookie applies
	Public String getPath()
	public void setPath(String path)
		This method should be used to set the cookies for all pages in a website for a group of pages or 		just for one page.

		For eg cookiename.setPath("?")  specifies that all pages on the server should receive the cookie.

Setting cookies over secure connections
	Public Boolean getSecure()
	public void setComment(Boolean secureFlag)
	This flag sets a flag to indicate if the cookie should be sent over encrypted (SSL) Connections.
	default is false. If set, the cookie should apply to all connections.

getting and setting values from cookies 
	Public String getValue()
	public void setValue(String cookieValue)
	getVlaue looks up the value and setValue sets the value.

Setting the version
	Public int getVersion()
	public void setVersion(String comment)
	These two method get/set the cookie protocol version that the cookie complies with.Version 0 follow the Netscape Specification. Version 1 follows RFC2109 specification. Version 1 is not widely implemented yet. */

 // Sets six cookies: three that apply only to the current
 //  session (regardless of how long that session lasts)
 //  and three that persist for an hour (regardless of
 // whether the browser is restarted).

package coreservlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;



public class Program7 extends HttpServlet {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    for(int i=0; i<3; i++) {
      // Default maxAge is -1, indicating cookie
      // applies only to current browsing session.
      Cookie cookie = new Cookie("Session-Cookie-" + i,
                                 "Cookie-Value-S" + i);
      response.addCookie(cookie);
      cookie = new Cookie("Persistent-Cookie-" + i,
                          "Cookie-Value-P" + i);
      // Cookie is valid for an hour, regardless of whether
      // user quits browser, reboots computer, or whatever.
      cookie.setMaxAge(3600);
      response.addCookie(cookie);
    } 
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String title = "Setting Cookies";
    out.println
      (ServletUtilities.headWithTitle(title) +
       "<BODY BGCOLOR=\"#FDF5E6\">\n" +
       "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" +
       "There are six cookies associated with this page.\n" +
       "To see them, visit the\n" +
       "<A HREF=\"ShowCookies\">\n" +
       "<CODE>ShowCookies</CODE> servlet</A>.\n" +
       "<P>\n" +
       "Three of the cookies are associated only with the\n" +
       "current session, while three are persistent.\n" +
       "Quit the browser, restart, and return to the\n" +
       "<CODE>ShowCookies</CODE> servlet to verify that\n" +
       "the three long-lived ones persist across sessions.\n" +
       "</BODY></HTML>");
  }
}
