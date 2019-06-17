package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class chooseOption
 */
@WebServlet("/chooseOption")
public class chooseOption extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String DOCTYPE =
		    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
		    "Transitional//EN\">";

	public static String headWithTitle(String title) {
		return(DOCTYPE + "\n" +
				"<HTML>\n" +
				"<HEAD><TITLE>" + title + "</TITLE></HEAD>\n");
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("Request ");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    String title = "Choosing Option";
	    out.println(headWithTitle(title) +
	                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
	                "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" +
	                "<TABLE BORDER=1 ALIGN=\"CENTER\">\n" +
	                "<TR BGCOLOR=\"#FFAD00\">\n");
	    String [] arr = {"1","2","3"};
	    String [] arr1 = {"5","2","3"};
	    out.println("<TR><TD>" + "first" + "<TD><select>");
	    for(int i = 0; i < arr.length; i++) {
	    	out.println("<option>" + arr[i]+"</option><br>");
	    }
	    out.println("<TR><TD>" + "last" + "<TD><select>");
	    for(int i = 0; i < arr.length; i++) {
	    	out.println("<option>" + arr1[i] +"</option>");
	    }
	    out.println("</select></TABLE>");
	    out.println("<form action=\"totalCost.jsp\" ALIGN=\"CENTER\">");
		out.println("<input type=\"submit\" value=\"OK\"/> ");
		out.println("</form>\n");
		out.println("</BODY></HTML>");
	}

}