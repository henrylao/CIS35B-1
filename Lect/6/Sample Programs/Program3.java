//Using Init Method
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Program3 extends HttpServlet 
{
    String msg = "";

    public void init(ServletConfig config)
    {
        msg = "Hello from Java servlets!";
    }

    public void doGet(HttpServletRequest request,
        HttpServletResponse response)
        throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<TITLE>");
        out.println("Using the init Method");
        out.println("</TITLE>");
        out.println("</HEAD>");
        out.println("<BODY>");
        out.println("<H1>Using the init Method</H1>");
        out.println(msg);
        out.println("</BODY>");
        out.println("</HTML>");
    }
}

