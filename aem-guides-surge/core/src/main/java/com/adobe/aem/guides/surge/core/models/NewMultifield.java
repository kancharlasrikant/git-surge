package com.adobe.aem.guides.surge.core.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import org.apache.sling.api.resource.Resource;

import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class NewMultifield {
    private static final Logger log = LoggerFactory.getLogger(NewMultifield.class);

    @ChildResource
    Resource multifield;

    @PostConstruct
    public void init() {
        log.info("all the properties get successfully");
    }

    public List<Map<String, Object>> getMultifield() {
        List<Map<String, Object>> mainmap = new ArrayList<Map<String, Object>>();

        if (multifield != null) {
            for (Resource childresource : multifield.getChildren()) {
                Map<String, Object> childmap = new HashMap<String, Object>();
                childmap.put("addres", childresource.getValueMap().get("address", String.class)); 
                childmap.put("pincode", childresource.getValueMap().get("pincode", String.class));
                mainmap.add(childmap);
            }
        }

        return mainmap;
    }
}