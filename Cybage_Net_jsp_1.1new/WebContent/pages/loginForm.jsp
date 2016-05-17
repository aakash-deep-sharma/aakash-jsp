<%@page import="com.dao.LoginDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="../pages/error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tlds/log" prefix="log" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/mainpage.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>

</head>

<body>
<%!
int onlineUser = 0;
void increaseCounter()
{
onlineUser += 1;	
}
%>
<%application.setAttribute("onlineUser",onlineUser) ;%>

<jsp:useBean id="UserDto" class="com.dto.UserDto" scope="session"></jsp:useBean>
<jsp:useBean id="LoginDao" class="com.dao.LoginDao" scope="session"></jsp:useBean>
<jsp:setProperty property="*" name="UserDto"/>

<h1>CYBAGE NET</h1>
<h4 align="left" style="color:purple; font-size: medium;">Total Hits ${hitCounter}</h4>
<h3>${status}</h3>

<c:set var="status" value="" scope="session"></c:set>


<form action="#" method="post">
	<table>
		<tr>
			<td><label>USERNAME</label></td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td><label>PASSWORD</label></td>
			<td><input type="password" name="pass"></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input  type="submit" value="LOGIN" name="btn"></td>
		</tr>
	</table>
</form>

<c:if test="${param.btn eq 'LOGIN'}">
	<jsp:setProperty property="loginDao" name="UserDto" value="${LoginDao}"/>
		<c:choose>

				<c:when test="${UserDto.role eq 'A'}">
					<log:log/>
					<jsp:useBean id="AdminDao" class="com.dao.AdminDao" scope="session"></jsp:useBean>
					<jsp:setProperty property="con" name="AdminDao" value="${LoginDao.con}"/>
					${AdminDao.pst}
					<c:redirect url="../pages/admin.jsp"></c:redirect>
					</c:when>

				<c:when test="${UserDto.role eq 'U'}">
					<log:log/>
					<%increaseCounter();
					 application.setAttribute("onlineUser",onlineUser) ;%>
					<jsp:useBean id="UserDao" class="com.dao.UserDao" scope="session"></jsp:useBean>
					<jsp:setProperty property="con" name="UserDao" value="${LoginDao.con}"/>
					${UserDao.pst}
					<c:redirect url="../pages/user.jsp"></c:redirect>
				</c:when>

				<c:otherwise>
					<c:set var="status" value="Invalid username or password" scope="session"></c:set>
					
					<c:redirect url="../pages/loginForm.jsp"></c:redirect>
				</c:otherwise>

		</c:choose>
</c:if>

</body>
</html>