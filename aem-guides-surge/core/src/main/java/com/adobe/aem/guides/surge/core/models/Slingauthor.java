package com.adobe.aem.guides.surge.core.models;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;

@Model(adaptables = Resource.class,
       adapters = Author.class,
       defaultInjectionStrategy = DefaultInjectionStrategy.REQUIRED
		)
public class Slingauthor implements Author{
	
	@Inject
	
	public String fname;
	
	
	@Inject
	
	public String lname;
	
	
	@Inject
	@Optional
	
	public boolean professor;
	
	
	
	
	
	

	@Override
	public String getFirstName() {
		// TODO Auto-generated method stub
		return fname;
	}

	@Override
	public String getLastName() {
		// TODO Auto-generated method stub
		return lname;
	}

	@Override
	public boolean getIsProfessor() {
		// TODO Auto-generated method stub
		return professor;
	}

}
