package com.adobe.aem.guides.surge.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

@Component(service=Servlet.class)
@WebServlet(name ="LoginPage",urlPatterns = "/login")
public class LoginPage extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String username = request.getParameter("username");
		String password =request.getParameter("password");
		
		boolean isAuthenticated = authenicate(username,password);
		
		if(isAuthenticated) {
			response.sendRedirect("/success-page.html");
			
		}else {
			response.sendRedirect("/login.html?error=1");
		}
	}

	private boolean authenicate(String username, String password) {
		
		return false;
	}
}
