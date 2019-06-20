package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import adapter.BuildAuto;
//import adapter.CreateAuto;
//import model.Automobile;
//import server.AutoServer;

/**
 * Servlet implementation class chooseOption
 */
@WebServlet("/chooseOption")
public class chooseOption extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	private AutoServer server;
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();

//		server = (AutoServer) session.getAttribute("server");
	    String carName = request.getParameter("carName");

//		CreateAuto a = (CreateAuto) server.getAuto(carName);
//		System.out.println(a.toString());
		PrintWriter out = response.getWriter();
	    String title = "Choosing Option";
	    out.println(headWithTitle(title) +
	                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
	                "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" +
	                "<form action=\"/CarConfiguration/totalCost.jsp\" ALIGN=\"right\">"+
	                "<TABLE BORDER=2 ALIGN=\"CENTER\">\n" +
	                "<TR BGCOLOR=\"#FFAD00\">\n");
//	    out.println(a.printAuto("carName"));
//	    String [] arr = {"1","2","3"};
//	    String [] arr1 = {"5","2","3"};
//	    out.println("<TR><TD>" + "first" + "<TD><select>");
//	    for(int i = 0; i < arr.length; i++) {
//	    	out.println("<option>" + arr[i]+"</option>");
//	    }
//	    out.println("</TR><tr><TD>" + "last" + "<TD><select>");
//	    for(int i = 0; i < arr.length; i++) {
//	    	out.println("<option>" + arr1[i] +"</option>");
//	    }
//	    out.println("</select></tr>");
	    out.println("<td colspan=2 align=right><input  align=center type=\"submit\" value=\"Done\"></td>");
		out.println("</form></TABLE></BODY></HTML>");
	}

}
