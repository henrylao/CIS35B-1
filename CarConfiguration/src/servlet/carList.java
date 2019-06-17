package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import adapter.BuildAuto;
import client.AutoClient;
import server.AutoServer;

/**
 * Servlet implementation class carList
 */
@WebServlet("/carList")
public class carList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
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
		/*
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		HttpSession session = request.getSession();
		ServletContext context = request.getServletContext();
		if(name!="" && name !=null) {
			session.setAttribute("saveUserName", name);
			context.setAttribute("saveUserName", name);
		}
		out.println("\nRequest " + name);
		out.println("\nSession  " + (String) session.getAttribute("saveUserName"));
		out.println("\nContext  "+ (String) context.getAttribute("saveUserName"));
		*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 String host = "127.0.0.1";
		 AutoServer serve = new BuildAuto();
		serve.serve(7777);
		AutoClient client = new BuildAuto();
		client.client(host, 7777);
		 */
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    String title = "Car List";
	    out.println(headWithTitle(title) +
	                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
	                "<H1 ALIGN=\"CENTER\">" + title + "</H1>");
	    out.println("<form method=\"post\" action=\"chooseOption\"  ALIGN=\"CENTER\">");
	    String [] arr = {"1","2","3"};
	    for(int i = 0; i < arr.length; i++) {
	    	out.println("<input type=\"radio\" name=\"carName\" value=\"" + i + "\">" + i + "</input>");
	    }
	    
	    
	    out.println("<input type=\"submit\" value=\"OK\"/> ");
		out.println("</form>\n");
		out.println("</BODY></HTML>");

		/*
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("userName");		
		String fullName = request.getParameter("fullName");
		out.println("Hello from the post method " + userName + "! We know your full name is "+ fullName);
		String prof = request.getParameter("prof");
		out.println("\nYou are a " + prof);
		//String location = request.getParameter("location");
		String [] location = request.getParameterValues("location");
		out.println("\nYou are" + location.length + "places");
		for (int i = 0; i<location.length; i++) {
			out.println(location[i]);
		}
		*/

	}

}
