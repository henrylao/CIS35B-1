
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import beans.Message;

//ServletForwardJsp.java

public class ServletForwardJsp extends HttpServlet 
{

    String target = "forward.jsp";

    Message model1 = new Message();

    public void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException 
    {
        request.setAttribute("message", model1.msg());
        RequestDispatcher dispatcher = 
            request.getRequestDispatcher(target);
        dispatcher.forward(request, response);
    } 
}
