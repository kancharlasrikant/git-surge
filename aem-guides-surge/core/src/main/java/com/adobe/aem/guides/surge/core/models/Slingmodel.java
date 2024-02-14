package com.adobe.aem.guides.surge.core.models;


import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;


@Model(adaptables= Resource.class)

public class Slingmodel {
	@ValueMapValue
	private String name;
	
	@ValueMapValue
	private String number;
	
	public String getFullName()
	{
	return name;
	}
			
	public String getNumber()
	{
	return number;	
	}
	
}
