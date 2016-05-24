package com.servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AdminDao;
import com.dao.LoginDao;
import com.dao.UserDao;
import com.utility.Utility;

/*Mapping is done by ANNOTATION */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	//This is taken for hit counting
	private static int count;
	//This is taken user counting
	private int visitorCount ;
	//Create refernce of LoginDao for establishing connection
	private LoginDao logDao;
	//Creating and maining session
	private HttpSession session;
 //To store user info inside cookie
	private Cookie ck;

	public LoginServlet() throws Exception 
    {
		visitorCount=0;
    	count=0;
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String status = (String)request.getAttribute("status");
		try
		{
			//if status returns failed it will be redirected to LOGIN PAGE
		if(status.contains("f"))
		{
			pw.println("<h2 align='center' style='font: 400;background-color:'red';font-weight: bold;'>Invalid username or password<h2>");
			RequestDispatcher rd = request.getRequestDispatcher("loginForm.html");
			rd.include(request, response);
		}
		else
		{
			//If status is sucessful it will return a string 
		String username =(String) request.getSession().getAttribute("uname");
		//take username from using session
		logDao =(LoginDao)request.getSession().getAttribute("loginDao");
		//establish connection
		
		session=request.getSession();
		pw.println("<h2 align='center'>Welcome "+username+"</h2>");
		//if staus is equal admin it will redirect it to admin page		
		if(status.equals("A"))
				{	
					Cookie[] cookies = request.getCookies();
					//if user has come for first time it cookies will be null
					if(cookies == null)
					{
						ck = new Cookie("visitors",Integer.toString(visitorCount));
						
					}
					else
					{
						//if its second time then its previously stored cookies will be used
						ck = cookies[0];
						ck.setValue(Integer.toString(visitorCount));
					}
					response.addCookie(ck);
					//Show HITS AND TOTAL NO OF USER
					pw.print("<h2 align='left'>Total Visits are:"+visitorCount+"</h2>");
					pw.print("<h2 align='left'>Count of online users are:"+count+"</h2>");
					
					AdminDao aDao = new AdminDao(logDao.getCon());
					session.setAttribute("adminDao",aDao);
					
					RequestDispatcher rd = request.getRequestDispatcher("admin.html");
					rd.include(request, response);
				}
				else
				{
					//IF STATUS IS NOT ADMIN IT MUST BE USER
					count++; //HIT INCREASED
					visitorCount++;//COUNT INCREASED
					UserDao uDao = new UserDao(logDao.getCon());
					session.setAttribute("userDao",uDao);
					RequestDispatcher rd = request.getRequestDispatcher("user.html");
					rd.include(request, response);
				}
				
				session.setAttribute("count", count);
				
					
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	 public static int getCount() {
			return count;
		}


		public static void setCount(int count) {
			LoginServlet.count = count;
		}
}

