//URL Rewrite
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Program18 extends HttpServlet {

  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, java.io.IOException {

    response.setContentType("text/html");
    java.io.PrintWriter out = response.getWriter();
    String contextPath = request.getContextPath();
    String encodedUrl = response.encodeURL(contextPath + "/default.jsp");

    out.println("<html>");
    out.println("<head>");
    out.println("<title>URL Rewriter</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>This page will use URL rewriting if necessary</h2>");
    out.println("Go to the default.jsp page <a href=\"" + encodedUrl
        + "\">here</a>.");
    out.println("</body>");
    out.println("</html>");

  }

  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, java.io.IOException {
    doGet(request, response);

  }
}

