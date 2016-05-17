 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cybage Net</title>
</head>
<body >
<h1 align="center">CYBAGE NET</h1>

<%!
int hitCounter = 0;
int onlineUser = 0;
void increaseCounter()
{
hitCounter=hitCounter+1;	
}
%>
<%
increaseCounter();
application.setAttribute("hitCounter", hitCounter);
%>
<h2 align="center">
<a href="pages/loginForm.jsp">LOGIN</a>
</h2>
</body>
</html>