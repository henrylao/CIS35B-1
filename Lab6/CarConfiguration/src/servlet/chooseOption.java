package servlet;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Automobile;

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
		return (DOCTYPE + "\n" +
				"<HTML>\n" +
				"<HEAD><TITLE>" + title + "</TITLE></HEAD>\n");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String carName = request.getParameter("carName");
	    ObjectOutputStream o = (ObjectOutputStream) session.getAttribute("out");
		ObjectInputStream i = (ObjectInputStream) session.getAttribute("in");
		try {
			o.writeObject(carName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AutoServlet s = (AutoServlet) session.getAttribute("interface");
		Automobile a = s.getCarObject(i);
		response.setContentType("text/html");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    String title = "Basic Car Choice";
	    out.println(headWithTitle(title) +
	                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
	                "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" +
	                "<form action=\"/CarConfiguration/totalCost.jsp\" ALIGN=\"right\" method=post>"+
	                "<TABLE BORDER=2 ALIGN=\"CENTER\" target=\"_blank\">\n" +
	                "<TR BGCOLOR=\"#FFAD00\">\n");
	    out.println(String.format("<tr><td>Make/Model:<td>%s %s</tr>", a.getMake(), a.getModel()));
		for(int m = 0; m < a.getOptionSetSize(); m++) {
			String [] optionSet = a.choiceInHtml(m).split("\n");
			out.println("<TR><TD>" + optionSet[0] + "<TD><select name=\"" +  optionSet[0] + "\">");
			for(int n = 1; n < optionSet.length; n++) {
				out.println("<option value=\"" + optionSet[n] + "\">" + optionSet[n]+"</option>");
			}
			out.println("</select></tr>");
		}
	    out.println("<td colspan=2 align=right><input align=center type=\"submit\" value=\"Done\"></td>");
		out.println("</form></TABLE></BODY></HTML>");
		session.setAttribute("car", a);

	}
}
