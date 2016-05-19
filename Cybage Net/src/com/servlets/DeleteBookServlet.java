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

import com.dao.AdminDao;



/**
 * Servlet implementation class DeleteBook
 */
//MAPPING IS DONE FROM ADMIN>HTML
@WebServlet("/DeleteBook")
public class DeleteBookServlet extends HttpServlet {
	
	private AdminDao adao;   
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		adao =  (AdminDao)request.getSession().getAttribute("adminDao");
		PrintWriter pw = response.getWriter();
		
		try {
			//LIST OF ALL BOOKS PRESENT IS GET
			
			String[] ids = request.getParameterValues("book");
			
			//DELETE BOOK ON ID
			adao.deleteBook(ids);
			pw.print("Deleted Succesfully");
			System.out.println("deleted");
			
			RequestDispatcher rd = request.getRequestDispatcher("admin.html");
			rd.include(request, response);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
