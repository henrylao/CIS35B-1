//Reading parameters from a file
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.io.IOException;

public class Program8 extends HttpServlet 
{
  public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
  {

    res.setContentType("text/plain");
    PrintWriter out = res.getWriter();

    String url = getInitParameter("URL");

    ServletConfig config = getServletConfig();
    ServletContext context = getServletContext();
    String uid = config.getInitParameter("UID");
    String pwd = config.getInitParameter("PWD");
    String port = context.getInitParameter("some-port");

    out.println("Values retrieved for the init parameters are: ");
    out.println("URL: " + url);
    out.println("UID: " + uid);
    out.println("PWD: " + pwd);
    out.println("some-port: " + port);
  }
}

