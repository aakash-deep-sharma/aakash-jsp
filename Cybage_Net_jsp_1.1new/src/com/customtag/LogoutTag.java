 package com.customtag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class LogoutTag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		System.out.println("start");
		PageContext ctx = (PageContext)getJspContext();
		HttpSession hs = ctx.getSession();
		hs.invalidate();
		HttpServletRequest request = (HttpServletRequest) ctx.getRequest();
		String path = request.getContextPath();
		//request.setAttribute("status","LogOut Successfully");
		HttpServletResponse resp = (HttpServletResponse) ctx.getResponse();
		resp.setHeader("refresh", "1;url=" + path);
		//resp.sendRedirect(path);
		System.out.println("end");
	}
	
}