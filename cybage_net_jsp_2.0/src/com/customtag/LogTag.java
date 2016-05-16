package com.customtag;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.dto.UserDto;

public class LogTag extends SimpleTagSupport{

	@Override
	public void doTag() throws JspException, IOException {
		PageContext ctx= (PageContext)getJspContext();
		HttpSession hs = ctx.getSession();
		
		UserDto user =(UserDto) hs.getAttribute("UserDto");
		
		try(PrintWriter log = new PrintWriter(new FileOutputStream("D://userlog.txt",true));)
		{
			log.write(user.getName()+"     ");
			log.println(new Date()+"    ");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
}