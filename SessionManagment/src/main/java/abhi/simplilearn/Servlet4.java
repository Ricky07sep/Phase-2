package abhi.simplilearn;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet4 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.setContentType("text/html");
			PrintWriter pwriter = response.getWriter();

			HttpSession session = request.getSession(false);

			String myName = (String) session.getAttribute("uname");
			String myPassword = (String) session.getAttribute("upass");
			String myAge = (String) session.getAttribute("uage");
			String myEmail = (String) session.getAttribute("uemail");
			String myCountry = (String) session.getAttribute("ucountry");
			
			pwriter.println("Name : " + myName + "<br>");
			pwriter.println("Password : " + myPassword + "<br>");
			pwriter.println("Age : " + myAge + "<br>");
			pwriter.println("Email : " + myEmail + "<br>");
			pwriter.println("Couontry : " + myCountry + "<br><br>");

			pwriter.println("session creation time : " + session.getCreationTime() + "<br>");
			pwriter.println("session last accessed time : " + session.getLastAccessedTime() + "<br>");
			pwriter.println("session max interval time : " + session.getMaxInactiveInterval() + "<br>");
			pwriter.println("session servelt context : " + session.getServletContext() + "<br>");
			pwriter.println("session servelt context : " + session.getId() + "<br>");
			pwriter.println(session.isNew() + "<br>");

			pwriter.close();
		} catch (Exception exp) {
			System.out.println(exp);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}
