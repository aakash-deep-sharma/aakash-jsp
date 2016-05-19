<%@page import="com.dao.AdminDao"%>
<%@page import="com.dao.LoginDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="../pages/error.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tlds/logout" prefix="logout"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../css/cybage.css"/>
<title>Admin Page</title>
</head>

<body>

<!-- putting book dto instance in session scope -->
<jsp:useBean id="BookDto" class="com.dto.BookDto" scope="session"></jsp:useBean>

<!-- setting property admindao of bookdto -->
<jsp:setProperty property="adminDao" name="BookDto" value="${AdminDao}"/>
<jsp:setProperty property="*" name="BookDto"/>

<!-- showing username using El syntax  -->
<h1 >Welcome ${UserDto.name}</h1>

<!-- showing total hit count and online user by using EL syntax
	both hitcounter and onlineuser store in application scope -->
<h4 align="left" style="color:purple; font-size: medium;">Total Hits : ${hitCounter}</h4>
<h4 align="left" style="color:purple; font-size: medium;">Online Users :  ${onlineUser}</h4>

<!-- showing status of last task performed by using EL syntax
	status stored in session scope -->
<h3 >${status}</h3>

<!-- replacing value stored in status by empty string  -->
<c:set var="status" value="" scope="session"></c:set>

<!-- form for add book ,delete book and logout option -->
<form action="#" method="post">
	<input type="submit" name="addBook"  value ="ADD BOOK">&nbsp&nbsp&nbsp
	<input type="submit" name="deleteBook"  value ="DELETE BOOKS">&nbsp&nbsp&nbsp
	<input align="right" type="submit" name="logout"  value ="LOGOUT">
</form>


<!-- checking if add book button is clicked -->
<c:if test="${param.addBook eq 'ADD BOOK'}">

	<!-- showing form for enter book details which admin want to add
		and submitting information on same page -->
	<h2 >ENTER BOOK DETAILS</h2>
		<form action="#" method="post">
			<table>
				<tr >
					<td><label> BOOK NAME :</label></td>
					<td><input type="text" name="bookName" required="required"></td>
				</tr>

				<tr >
					<td><label>BOOK AUTHOR :</label></td>
					<td><input type="text" name="bookAuthor" required="required"></td>
				</tr>

				<tr>
					<td><label>BOOK PRICE :</label></td>
					<td><input type="text" name="bookPrice" required="required"></td>
				</tr>

				<tr>
					<td colspan="3" align="center"><input type="submit" name="add" value="ADD"></td>
				</tr>
			</table>
		</form>
</c:if>
	
<!-- checking if add button is clicked or not -->
<c:if test="${param.add eq 'ADD'}">

	<!-- calling method of book dto and adding book in data base
		if it is not exist earlier  -->
	<c:set var="status" value="${BookDto.addBook}" scope="session"></c:set>
	
	<!-- redirecting to same page -->
	<c:redirect url="../admin/admin.jsp"></c:redirect>
</c:if>



<!--  checking delete book button is clicked or not -->
<c:if test="${param.deleteBook eq 'DELETE BOOKS'}">
    
    <!-- showing all books present in database -->
    <h2 >Select Books To Delete</h2>
    
    	<!-- selecting multiple books and deleting books using 
    		delete book servlet  -->
		<form action="../DeleteBookServlet" method="post">
			<table >
				<c:forEach items="${AdminDao.books}" var="book">
					<tr>
						<td> <input type="checkbox" value="${book.bookId}" name="books"> </td>
						<td> ${book.bookName} </td>
						<td> ${book.bookAuthor} </td>
					</tr>
				</c:forEach>
					<tr>
						<td colspan="3" align="center"><input
						type="submit" name="delete" value="DELETE"></td>
					</tr>
			</table>
		</form>
</c:if>


<!-- checking if logout button is clicked or not -->
<c:if test="${param.logout eq 'LOGOUT'}">
	
	<!-- logout the user using custom tag -->
	<logout:logout/>
</c:if>

</body>
</html>