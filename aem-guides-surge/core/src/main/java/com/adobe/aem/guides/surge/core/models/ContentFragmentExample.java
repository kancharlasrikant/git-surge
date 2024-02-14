package com.adobe.aem.guides.surge.core.models;

import java.util.HashMap;
import java.util.Map;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.PersistenceException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

@Component(immediate = true, service = ContentFragmentExample.class)
public class ContentFragmentExample {

    @Reference
    private ResourceResolverFactory resourceResolverFactory;

    public void createContentFragment(String fragmentName) throws RepositoryException, PersistenceException, LoginException {
        ResourceResolver resourceResolver = null;
        try {
            // Prepare service user authentication info
            final Map<String, Object> authInfo = new HashMap<>();
            authInfo.put(ResourceResolverFactory.SUBSERVICE, "Surgetestuser");

            // Get service resource resolver
            resourceResolver = resourceResolverFactory.getServiceResourceResolver(authInfo);

            // Get the page manager
            PageManager pageManager = resourceResolver.adaptTo(PageManager.class);

            // Get the containing page
            Page page = pageManager.getContainingPage("/content/surge");

            // Get the session
            Session session = resourceResolver.adaptTo(Session.class);

            // Get the parent node
            Node parentNode = session.getNode(page.getPath() + "/jcr:content");

            // Add the fragment node
            Node fragmentNode = parentNode.addNode("myFragment", "dam:ContentFragment");
            fragmentNode.setProperty("title", "Surge contentFragment");
            fragmentNode.setProperty("description", "This is My Content Fragment");

            // Save the session
            session.save();
        } finally {
            // Always close the resource resolver
            if (resourceResolver != null && resourceResolver.isLive()) {
                resourceResolver.close();
            }
        }
    }
}
