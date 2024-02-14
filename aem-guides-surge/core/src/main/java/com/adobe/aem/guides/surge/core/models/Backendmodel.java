package com.adobe.aem.guides.surge.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables=Resource.class)
public class Backendmodel {
@ValueMapValue
private String name;
@ValueMapValue
private String number;
public String getname() {
	return name;
}
public String number() {
	return number;
}
}
