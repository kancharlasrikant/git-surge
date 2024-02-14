package com.adobe.aem.guides.surge.core.listeners;

import java.util.EventListener;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.observation.Event;
import javax.jcr.observation.EventIterator;

import org.apache.sling.jcr.api.SlingRepository;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(immediate = true, service = EventListener.class)
public class JCREventHandler implements EventListener, javax.jcr.observation.EventListener {
    private static final Logger log = LoggerFactory.getLogger(JCREventHandler.class);
    private Session session;

    @Reference
    private SlingRepository slingRepository;

    @Activate
    protected void activate() {
        try {
            session = slingRepository.loginService("SurgeServiceUser", null);
            session.getWorkspace().getObservationManager().addEventListener(
                    this,
                    Event.NODE_ADDED | Event.PROPERTY_ADDED,
                    "/content/surge/us/en/accordion",
                    true,
                    null,
                    null,
                    false);

            log.info("JCREventHandler activated");
        } catch (RepositoryException e) {
            log.error("Error while adding Event Listener: {}", e.getMessage(), e);
        }
    }

    @Deactivate
    protected void deactivate() {
        if (session != null && session.isLive()) {
            session.logout();
        }
        log.info("JCREventHandler deactivated");
    }

    public void onEvent(EventIterator eventIterator) {
        try {
            while (eventIterator.hasNext()) {
                Event event = eventIterator.nextEvent();
                if (event != null) {
                    log.info("Type: {}, Path: {}", event.getType(), event.getPath());
                }
            }
        } catch (Exception e) {
            log.error("Error while processing events: {}", e.getMessage(), e);
        }
    }
}
