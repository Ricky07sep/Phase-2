package abhi.simplilearn;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) {

		try {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			String user = request.getParameter("username");
			String pass = request.getParameter("password");
			out.print("Welcome : " + user);

			Cookie ck = new Cookie("Username", user); // creating cookie object
			response.addCookie(ck); // adding cookie in the response
			ck = new Cookie("Password", pass);
			response.addCookie(ck);
			
			// creating submit button
			out.print("<form action='un_pass'>");
			out.print("<input type='submit' value='Next'>");
			out.print("</form>");

			out.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}
