package com.adobe.aem.guides.surge.core.models;



import java.util.ArrayList;
import java.util.List;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

@Model(adaptables = Resource.class,
defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class FruitList {
	@SlingObject
	private Resource resource;
	
	public List<String> getFruits(){
		List<String> fruits = new ArrayList<>();
		fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Grapes");
			
		
		return fruits;
		
	}

}
