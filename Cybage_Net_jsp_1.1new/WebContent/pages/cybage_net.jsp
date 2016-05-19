 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="pages/error.jsp"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cybage Net</title>
</head>
<body >

<h1 align="center">CYBAGE NET</h1>


<!-- initialize hit counter to zero -->
<%!
int hitCounter = 0;
%> 

<!-- initializing online user to 0 and put it in application 
scope variable to  -->

<c:set var="onlineUser" value="${0}" scope="application"></c:set>




<!-- whenever user visit to this page the hit counter increases
 by 1 and saved in application scope -->
 
<c:set var="hitCounter" value="${hitCounter + 1 }" scope="application"></c:set>
<h2 align="center">




<!-- link for login form -->

<a href="pages/loginForm.jsp">LOGIN</a>
</h2>
</body>
</html>