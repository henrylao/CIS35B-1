/*-----Accessing the CGI Standard Variables
CGI - Common Gateway Interface allows execution of several types of programs and is  collection of information about the current request.

Information is collected for HTTP request header or thru sockets by connecting to the requesting host.

Following is the collection of CGI Variables
AUTH_TYPE 	- Gives authorization type in Authorization header, if one is available(basic or digest.)	
CONTENT_LENGTH	- For POST Requests only. Size in Bytes indicating the size of data in POST.
CONTENT_TYPE 	- designate the MIME Type of attached data.
DOCUMENT_ROOT	- Provides name of the real directory corresponding to the URL
HTTO_XXX_YYYY	- gives information on HTTP Request header
PATH_INFO	- gives path information attached to the URL after the address of the servlet - but before query data
PATH_TRANSLATED	- gives path information mapped to the real path on the server
QUERY_STRING	- Provides raw data in the servlet
REMOTE_ADDR 	- Indicates the IP Address of the client that made the request
REMOTE_HOST	- Indicates fully qualified Domain name
REMOTE_USER	- If authorization header is available, then the user information accessed can be used for session tracking
REQUEST_METHOD 	- gives information on the method type.
SCRIPT_NAME    	- gives path to the servlet name
SERVER_NAME 	- host name
SERVER_PORT 	- information about the port that the server is listening on
SERVER_PROTOCOL - gives protocol name and version egHTTP/1.0 or 1.1
SERVER_SOFTWARE - information about webserver */

package coreservlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class ShowCGIVariables extends HttpServlet {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String[][] variables =
      { { "AUTH_TYPE", request.getAuthType() },
        { "CONTENT_LENGTH",
          String.valueOf(request.getContentLength()) },
        { "CONTENT_TYPE", request.getContentType() },
        { "DOCUMENT_ROOT",
          getServletContext().getRealPath("/") },
        { "PATH_INFO", request.getPathInfo() },
        { "PATH_TRANSLATED", request.getPathTranslated() },
        { "QUERY_STRING", request.getQueryString() },
        { "REMOTE_ADDR", request.getRemoteAddr() },
        { "REMOTE_HOST", request.getRemoteHost() },
        { "REMOTE_USER", request.getRemoteUser() },
        { "REQUEST_METHOD", request.getMethod() },
        { "SCRIPT_NAME", request.getServletPath() },
        { "SERVER_NAME", request.getServerName() },
        { "SERVER_PORT",
          String.valueOf(request.getServerPort()) },
        { "SERVER_PROTOCOL", request.getProtocol() },
        { "SERVER_SOFTWARE",
          getServletContext().getServerInfo() }
      };
    String title = "Servlet Example: Showing CGI Variables";
    out.println(ServletUtilities.headWithTitle(title) +
                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" +
                "<TABLE BORDER=1 ALIGN=\"CENTER\">\n" +
                "<TR BGCOLOR=\"#FFAD00\">\n" +
                "<TH>CGI Variable Name<TH>Value");
    for(int i=0; i<variables.length; i++) {
      String varName = variables[i][0];
      String varValue = variables[i][1];
      if (varValue == null)
        varValue = "<I>Not specified</I>";
      out.println("<TR><TD>" + varName + "<TD>" + varValue);
    }
    out.println("</TABLE></BODY></HTML>");
  }

  /** POST and GET requests handled identically. */
  
  public void doPost(HttpServletRequest request,
                     HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}
