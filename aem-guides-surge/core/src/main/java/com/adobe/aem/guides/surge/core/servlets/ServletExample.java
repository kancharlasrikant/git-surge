package com.adobe.aem.guides.surge.core.servlets;
import java.io.IOException;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;


@Component(service=Servlet.class,
property ={
	 "sling.Servlet.paths=/bin/krishna/surge"
})

public class ServletExample extends SlingSafeMethodsServlet{
@Override
public void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)throws ServletException, IOException {
	JsonObjectBuilder objectbuilder=Json.createObjectBuilder();
	objectbuilder.add("krishna", "surge");
	objectbuilder.add("surya", "surge");
	objectbuilder.add("kanth", "surge");
	response.getWriter().write(objectbuilder.build().toString());
	
}
	 
}