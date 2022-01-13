package abhi.simplilearn;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EmployeeHome extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.setContentType("text/html");
			PrintWriter pwriter = response.getWriter();

			String name = request.getParameter("username");
			String age = request.getParameter("age");
			String city = request.getParameter("city");
			String gender = request.getParameter("gender");
			String email = request.getParameter("email");

			pwriter.print("Welcome " + name + "<br><br>");
			pwriter.print("Your details are below:<br><br> ");
			pwriter.print("Age : " + age + "<br>");
			pwriter.print("City : " + city + "<br>");
			pwriter.print("Gender : " + gender + "<br>");
			pwriter.print("Email : " + email + "<br>");

			// creating the HttpSession below
			HttpSession session = request.getSession();

			session.setAttribute("uname", name);
			session.setAttribute("uage", age);
			session.setAttribute("ucity", city);
			session.setAttribute("ugender", gender);
			session.setAttribute("uemail", email);

			pwriter.print("<a href='details'>Show More</a>");
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
