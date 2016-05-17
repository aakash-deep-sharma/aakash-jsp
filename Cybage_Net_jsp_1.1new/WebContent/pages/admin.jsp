<%@page import="com.dao.AdminDao"%>
<%@page import="com.dao.LoginDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="pages/error.jsp"%>
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


<jsp:useBean id="BookDto" class="com.dto.BookDto" scope="session"></jsp:useBean>
<jsp:setProperty property="adminDao" name="BookDto" value="${AdminDao}"/>
<jsp:setProperty property="*" name="BookDto"/>


<h1 >Welcome ${UserDto.name}</h1>
<h4 align="left" style="color:purple; font-size: medium;">Total Hits : ${hitCounter}</h4>
<h4 align="left" style="color:purple; font-size: medium;">Online Users :  ${onlineUser}</h4>
<h3 >${status}</h3>
<c:set var="status" value="" scope="session"></c:set>

<form action="#" method="post">
	<input type="submit" name="addBook"  value ="ADD BOOK">&nbsp&nbsp&nbsp
	<input type="submit" name="deleteBook"  value ="DELETE BOOKS">&nbsp&nbsp&nbsp
	<input align="right" type="submit" name="logout"  value ="LOGOUT">
</form>

<c:if test="${param.addBook eq 'ADD BOOK'}">
	<h2 >ENTER BOOK DETAILS</h2>
		<form action="#" method="post">
			<table>
				<tr >
					<td><label> BOOK NAME :</label></td>
					<td><input type="text" name="bname"></td>
				</tr>

				<tr >
					<td><label>BOOK AUTHOR :</label></td>
					<td><input type="text" name="bauthor"></td>
				</tr>

				<tr>
					<td><label>BOOK PRICE :</label></td>
					<td><input type="text" name="bprice"></td>
				</tr>

				<tr>
					<td colspan="3" align="center"><input type="submit" name="add" value="ADD"></td>
				</tr>
			</table>
		</form>
</c:if>
	
	
<c:if test="${param.add eq 'ADD'}">
	<c:set var="status" value="${BookDto.addBook}"></c:set>
	<c:redirect url="pages/admin.jsp"></c:redirect>
</c:if>


<c:if test="${param.deleteBook eq 'DELETE BOOKS'}">
    <h2 >Select Books To Delete</h2>
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
						class="sub_button"type="submit" name="delete" value="DELETE"></td>
					</tr>
			</table>
		</form>
</c:if>



<c:if test="${param.logout eq 'LOGOUT'}">
	<logout:logout/>
</c:if>

</body>
</html>