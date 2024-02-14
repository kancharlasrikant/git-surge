package com.adobe.aem.guides.surge.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
@Component(service=Servlet.class,
property = {
        "sling.servlet.paths=/content/myproject/mypage",
        "sling.servlet.methods=GET"
    }
)

public class Newservlet extends SlingSafeMethodsServlet{
	
	
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().write("Hello from MyServlet at /content/myproject/mypage.html");
	}
	}


