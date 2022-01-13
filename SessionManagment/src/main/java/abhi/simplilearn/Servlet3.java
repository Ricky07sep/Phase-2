package abhi.simplilearn;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet3 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.setContentType("text/html");
			PrintWriter pwriter = response.getWriter();

			String name = request.getParameter("username");
			String password = request.getParameter("password");
			String age = request.getParameter("age");
			String email = request.getParameter("email");
			String country = request.getParameter("country");

			pwriter.print("Welcome " + name + "<br><br>");

			// creating the HttpSession below
			HttpSession session = request.getSession();

			session.setAttribute("uname", name);
			session.setAttribute("upass", password);
			session.setAttribute("uage", age);
			session.setAttribute("uemail", email);
			session.setAttribute("ucountry", country);

			pwriter.print("<a href='details'>Next</a>");
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
