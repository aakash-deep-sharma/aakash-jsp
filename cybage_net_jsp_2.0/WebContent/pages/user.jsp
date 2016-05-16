<%@page import="com.dto.BookDto"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.UserDao"%>
<%@page import="com.dao.LoginDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="pages/error.jsp"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="/WEB-INF/tlds/logout" prefix="logout" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/cybage.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Page</title>

</head>

<body>

<jsp:useBean id="BookDto" class="com.dto.BookDto" scope="session"></jsp:useBean>
<jsp:setProperty property="*" name="BookDto"/>
<jsp:setProperty property="userDao" name="BookDto" value="${UserDao}"/>

<h1>Welcome ${UserDto.name}</h1>
<h4 align="left" style="color:purple; font-size: medium;">Total Hits ${hitCounter}</h4>
<h3>${status}</h3>
<c:set var="status" value=""></c:set>


<form action="#" method="post">
	<input type="text" name="bookName">
	<input type="submit" name="searchBook"  value ="SEARCH">&nbsp&nbsp&nbsp
	<input type="submit" name="logout" value ="LOGOUT">
</form>

<c:if test="${param.searchBook eq 'SEARCH'}">
	<h2>Search Result</h2>
	<form action="#">
		<table>
				<tr>
					<th>CHOOSE</th>
					<th>BOOK NAME</th>
					<th>BOOK AUTHOR</th>
					<th>BOOK PRICE</th>
				</tr>
			<c:forEach items="${BookDto.searchBooks}" var="book">			
				<tr>
					<td><input type="radio" value="${book.bookId}" name="bookId"></td>
					<td> ${book.bookName} </td>
					<td> ${book.bookAuthor} </td>
					<td> ${book.bookPrice} </td>
				</tr>
			</c:forEach>
				<tr>
					<td colspan="4"><input type="submit" value="SHOW DETAILS" name="showReview"></td>
				</tr>
				</table>
	</form>
</c:if>


<c:if test="${param.showReview eq 'SHOW DETAILS'}">
		<h2>Book Details </h2>
			<jsp:setProperty property="bookId" name="BookDto" value="${param.bookId}"/>
			<c:set var="book" value="${BookDto.book}"></c:set>
				<table>
					<tr>
						<td><label>BOOK NAME :</label> </td>
						<td> ${book.bookName} </td>
					</tr>
					<tr>
						<td><label>BOOK AUTHOR :</label> </td>
						<td> ${book.bookAuthor} </td>
					</tr>
					<tr>
						<td><label>BOOK PRICE :</label> </td>
						<td> ${book.bookPrice} </td>
					</tr>
				</table>
				
				<h2 class="sub_title">Reviews </h2>
			<c:forEach items="${BookDto.showReviews}" var="review">
				<table>
					<tr>
						<td>*</td>
						<td>${review}</td>
					</tr>
				</table>
			</c:forEach>
				<form action="#">
					<input type="text" name="review">
					<input type="submit" name="reviewb" value="ADD REVIEW" >
				</form>
</c:if>

<c:if test="${param.reviewb eq 'ADD REVIEW'}">
	<h2>Book Details </h2>
		<jsp:setProperty property="bookReview" name="BookDto" value="${param.review}"/>
		<c:set var="status" value="${BookDto.addReview}" scope="session"></c:set>
		<c:set var="book" value="${BookDto.book}"></c:set>
		
		<table>
				<tr>
					<td><label>BOOK NAME :</label> </td>
					<td> ${book.bookName} </td>
				</tr>
				<tr>
					<td><label>BOOK AUTHOR : </label></td>
					<td> ${book.bookAuthor} </td>
				</tr>
				<tr>
					<td><label>BOOK PRICE : </label></td>
					<td> ${book.bookPrice} </td>
				</tr>
			</table>

	<h2 class="sub_title">Reviews </h2>
		<c:forEach items="${BookDto.showReviews}" var="review">
			<table>
				<tr>
					<td>${review}</td>
				</tr>
			</table>
			
			</c:forEach>
		<form action="#">
			<input type="text" name="review">
			<input type="submit" name="reviewb" value="ADD REVIEW" >
		</form>
</c:if>

<c:if test="${param.logout eq 'LOGOUT'}">
	<logout:logout/>
	
</c:if>

</body>
</html>
				

