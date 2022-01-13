<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


----------Marksheet ------- 
<c:set var="Amount" value="64" />
<p>Marks 1:  
<fmt:formatNumber type="number" groupingUsed="true" value="${Amount}"/> total : 100 </p>
<c:set var="Amount1" value="70" /> 
<p>Marks 2:  
<fmt:formatNumber type="number" groupingUsed="true" value="${Amount1}" /> total : 100 </p>
<c:set var="Amount2" value="35" />
<p>Marks 3:  
<fmt:formatNumber type="number" value="${Amount2}" /> total : 100 </p> 
<c:set var="Amount3" value="80" />
<p>Marks 4:  
<fmt:formatNumber type="number"  value="${Amount3}" /> total : 100 </p> 
<c:set var="Amount4" value="20" />
<p>Marks 5:  
<fmt:formatNumber type="number"  value="${Amount4}" /> total : 100 </p>   
<p> Total marks: <fmt:formatNumber type="number" groupingUsed="true" value="${Amount +Amount1+Amount2+Amount3+Amount4}"/>
<p> Percentage: <fmt:formatNumber type="number" groupingUsed="true" value="${(Amount +Amount1+Amount2+Amount3+Amount4)/5}"/>  </p>

----------Fees for Semester ------- 
<c:set var="fee" value="10000" />
<p>Fees paid for semester 1:  
<fmt:formatNumber type="number" groupingUsed="true" value="${fee}"/></p>
<c:set var="fee1" value="15000" /> 
<p>Fees paid for semester 2:  
<fmt:formatNumber type="number" groupingUsed="true" value="${fee1}" /></p>
<c:set var="fee2" value="20000" />
<p>Fees paid for semester 3:  
<fmt:formatNumber type="number" value="${fee2}" /></p> 
<c:set var="fee3" value="25000" />
<p>Fees paid for semester 4:  
<fmt:formatNumber type="number"  value="${fee3}" /></p>
<p> Total fees paid: <fmt:formatNumber type="number" groupingUsed="true" value="${fee+fee1+fee2+fee3}"/>
</body>
</html>