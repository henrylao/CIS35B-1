package servlet;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import adapter.BuildAuto;

/**
 * Servlet implementation class carList
 */
@WebServlet("/carList")
public class carList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Socket sock;

//    private AutoServer server;
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
	
	public void init(ServletConfig config) throws ServletException {
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.sock = new Socket(request.getServerName() , 7777);
		ObjectOutputStream o = new ObjectOutputStream(sock.getOutputStream());
		ObjectInputStream i = new ObjectInputStream(sock.getInputStream());
		try {
			i.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		o.writeObject(2);
		AutoServlet s = new BuildAuto();
		String[] listcar = (s.getCarList(i)).split("\n");
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    String title = "Car List";
	    out.println(headWithTitle(title) +
	                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
	                "<H1 ALIGN=\"CENTER\">" + title + "</H1>");
	    out.println("<form method=\"post\" action=\"/CarConfiguration/chooseOption\"  ALIGN=\"CENTER\">");
	    for(int j = 0; j < listcar.length; j++) {
	    	out.println("<input type=\"radio\" name=\"carName\" value=\"" + listcar[j++] + "\" ");
	    	if (j == 1)
	    		out.println("checked");
	    	out.println(">" + listcar[j] + "</input><br>");
	    }  
	    out.println("<p><input align=center type=\"submit\" value=\"Yes\"></p>");
		out.println("</form></BODY></HTML>");
		
		HttpSession session = request.getSession();
		session.setAttribute("in", i);
		session.setAttribute("out", o);
		session.setAttribute("interface", s);
	}

}
