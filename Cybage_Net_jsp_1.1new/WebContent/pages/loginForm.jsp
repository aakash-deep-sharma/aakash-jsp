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

<!-- putting login dao instance in session scope -->
<jsp:useBean id="LoginDao" class="com.dao.LoginDao" scope="session"></jsp:useBean>

<!-- putting user dto instance in session scope -->
<jsp:useBean id="UserDto" class="com.dto.UserDto" scope="session"></jsp:useBean>
<jsp:setProperty property="*" name="UserDto"/>

<h1>CYBAGE NET</h1>
<h4 align="left" style="color:purple; font-size: medium;">Total Hits ${hitCounter}</h4>

<!-- using EL syntax showing the status of previous task performed
	 here status variable stored in session scope -->
<h3>${status}</h3>

<!-- replacing value stored in status by empty string  -->
<c:set var="status" value="" scope="session"></c:set>



<!-- common login form for user and admin and submiting data
	 on same page -->
<form action="#" method="post">
	<table>
		<tr>
			<td><label>USERNAME</label></td>
			<td><input type="text" name="name" required="required"></td>
		</tr>
		<tr>
			<td><label>PASSWORD</label></td>
			<td><input type="password" name="pass" required="required"></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input  type="submit" value="LOGIN" name="btn"></td>
		</tr>
	</table>
</form>



<!-- checking if submit button is clicked or not using jstl library
	 after checking validating data and according to data redirecting
	 to respective page -->
<c:if test="${param.btn eq 'LOGIN'}">
	<jsp:setProperty property="loginDao" name="UserDto" value="${LoginDao}"/>
		<c:choose>


				
				<c:when test="${UserDto.role eq 'A'}">
				
					<!-- generating log using custom tag -->
					<log:log/>
					
					<!-- putting admin dao in session -->
					<jsp:useBean id="AdminDao" class="com.dao.AdminDao" scope="session"></jsp:useBean>
					
					<!-- setting connection property of admindao -->
					<jsp:setProperty property="con" name="AdminDao" value="${LoginDao.con}"/>
					
					<!-- creating all prepared statements by calling admin dao method
						 using EL syntax -->
					${AdminDao.pst}
					
					<!-- redirecting to admin page -->
					<c:redirect url="../admin/admin.jsp"></c:redirect>
				</c:when>


				
				<c:when test="${UserDto.role eq 'U'}">
				
					<!-- generating log using custom tag -->
					<log:log/>
					
					<!-- increasing online user count by 1 and saving it in 
						application scope -->
					<c:set var="onlineUser" value="${onlineUser + 1 }" scope="application"></c:set>
					
					
					<!-- putting user dao in session -->
					<jsp:useBean id="UserDao" class="com.dao.UserDao" scope="session"></jsp:useBean>
					
					<!-- setting connection property of user dao -->
					<jsp:setProperty property="con" name="UserDao" value="${LoginDao.con}"/>
					
					<!-- creating all prepared statements by calling admin dao method
						 using EL syntax -->
					${UserDao.pst}
					
					<!-- redirecting to user page -->
					<c:redirect url="../pages/user.jsp"></c:redirect>
				</c:when>


				
				<c:otherwise>
				
					<!-- set the status to appropriate message -->
					<c:set var="status" value="Invalid username or password" scope="session"></c:set>
					<c:redirect url="../pages/loginForm.jsp"></c:redirect>
				</c:otherwise>

		</c:choose>
</c:if>

</body>
</html>