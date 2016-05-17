package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AdminDao;



/**
 * Servlet implementation class DeleteBook
 */
@WebServlet("/DeleteBookServlet")
public class DeleteBookServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession hs = request.getSession();
		AdminDao adminDao =  (AdminDao)hs.getAttribute("AdminDao");
		
		try {
			String[] ids = request.getParameterValues("books");
			
			String result =adminDao.deleteBook(ids);
			if(result.contains("s"))
			{
				hs.setAttribute("status","Books Deleted Succesfully");
				response.sendRedirect("pages/admin.jsp");
			}
			
			} catch (SQLException e) {
			hs.setAttribute("status","Books Not Deleted");
			response.sendRedirect("pages/admin.jsp");
			e.printStackTrace();
		}
		
	}

}