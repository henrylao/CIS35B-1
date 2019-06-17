//Refreshing a page automatically
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AutoServlet extends HttpServlet {

  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, java.io.IOException {

    //client browser will request the page every 60 seconds
    HttpSession session = request.getSession();
    Long times = (Long) session.getAttribute("times");
    if (times == null)
      session.setAttribute("times", new Long(0));
    long temp = 1;
    if (times != null)
      temp = (times.longValue()) + 1;

    if (temp < 5)
      response.addHeader("Refresh", "15");

    response.setContentType("text/html");
    java.io.PrintWriter out = response.getWriter();
    out.println("<html><head><title>Client Refresh</title></head><body>");

    //More HTML or dynamic content
    out.println("You've viewed this page " + temp + " times.");
    session.setAttribute("times", new Long(temp));
    out.println("</body></html>");

  } //end doGet
}

