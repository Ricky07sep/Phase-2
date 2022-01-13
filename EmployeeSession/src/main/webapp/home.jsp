<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Page</title>
</head>
<body>

<%
String name = request.getParameter("username");
out.print("Welcome "+name);
%>
<br><br><br>

Expression Tag:::: Current Time : <%= java.util.Calendar.getInstance().getTime() %><br>
<%= "City : " +request.getParameter("city")%><br>
<%= "Age : " +request.getParameter("age")%><br>
<%= "Gender : " +request.getParameter("gender")%><br>
<%= "Email : " +request.getParameter("email")%>

<br><br><br>
Declaration Tag ::::
<%! 
int length = 10;
int width = 5;
int area = length * width;
%>
<%="Area of ractangle is : "+area %>

</body>
</html>