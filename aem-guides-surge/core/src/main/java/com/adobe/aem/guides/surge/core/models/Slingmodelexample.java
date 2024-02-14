package com.adobe.aem.guides.surge.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;


@Model(adaptables= SlingHttpServletRequest.class,
		defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class Slingmodelexample {
	@Default(values="global")
	@ValueMapValue
	private String name;
	@ValueMapValue
	private String number;
	public String getName() {
		return name;
	}
	public String getNumber() {
		return number;
	}
	
	
	
	
	
	

}
