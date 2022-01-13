package abhi.simplilearn;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeDashboard extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
            
        String username = request.getParameter("username");
        String password = request.getParameter("password");
         
        //creating a new hidden form field
        out.println("Welcome "+username);
        out.println("<form action='employeeFetch' method='post'>");
        out.println("<input type='hidden' name='username' id='userid' value='"+username+"'>");
        out.println("<input type='hidden' name='password' id='userid' value='"+password+"'>");
        out.println("<input type='submit' value='submit' >");
        out.println("</form>");
}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        doGet(request, response);
}
}
