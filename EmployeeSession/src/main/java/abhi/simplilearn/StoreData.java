package abhi.simplilearn;

import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class StoreData extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.setContentType("text/html");
			PrintWriter pwriter = response.getWriter();

			HttpSession session = request.getSession(false);

			String myName = (String) session.getAttribute("uname");
			String myAge = (String) session.getAttribute("uage");
			String myCity = (String) session.getAttribute("ucity");
			String myGender = (String) session.getAttribute("ugender");
			String myEmail = (String) session.getAttribute("uemail");
			

			pwriter.println("session creation time : " + session.getCreationTime()+"<br>");
			pwriter.println("session last accessed time : " + session.getLastAccessedTime()+"<br>");
			pwriter.println("session max interval time : " + session.getMaxInactiveInterval()+"<br>");
			pwriter.println("session servelt context : " + session.getServletContext()+"<br>");
			pwriter.println("session servelt context : " + session.getId()+"<br>");
			pwriter.println(session.isNew()+"<br>");
			
			pwriter.println("Name : "+myName+"<br>");
			pwriter.println("Age : "+myAge+"<br>");
			pwriter.println("City : "+myCity+"<br>");
			pwriter.println("Gender : "+myGender+"<br>");
			pwriter.println("Email : "+myEmail+"<br>");

			pwriter.close();
		} catch (Exception exp) {
			System.out.println(exp);
		}
	}
}
