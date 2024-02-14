package com.adobe.aem.guides.surge.core.listeners;

import com.day.cq.replication.ReplicationAction;
import com.day.cq.replication.ReplicationActionType;
import com.day.cq.replication.Replicator;
import com.day.cq.wcm.api.PageEvent;

import org.apache.sling.api.SlingConstants;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(
    service = EventHandler.class,
    immediate = true,
    property = {
        EventConstants.EVENT_TOPIC + "=org/apache/sling/api/resource/*"
    }
)
public class CaEventHandler implements EventHandler {
    private final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void handleEvent(Event event) {
		logger.error("Event Topic ={},path ={}",event.getTopic(),
				event.getProperty(SlingConstants.PROPERTY_PATH));
				
//		LOG.info("iam writing some dummy message about the caEventhandler");
		
	}

//    public void handleEvent(final Event event) {
//        try {
//            LOG.info("\n Event Type: {}", event.getTopic());
//            if (ReplicationAction.fromEvent(event).getType().equals(ReplicationActionType.ACTIVATE)) {
//                LOG.info("\n Page Published:  {}", ReplicationAction.fromEvent(event).getPath());
//            }
//            if (ReplicationAction.fromEvent(event).getType().equals(ReplicationActionType.DEACTIVATE)) {
//                LOG.info("\n Page Deactivated:  {}", ReplicationAction.fromEvent(event).getPath());
//            }
//        } catch (Exception e) {
//            LOG.error("\n Error while Activating/Deactivating - {}", e.getMessage());
//        }
    }

