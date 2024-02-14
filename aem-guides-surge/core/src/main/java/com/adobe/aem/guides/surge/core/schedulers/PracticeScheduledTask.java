package com.adobe.aem.guides.surge.core.schedulers;

import org.apache.sling.commons.scheduler.ScheduleOptions;
import org.apache.sling.commons.scheduler.Scheduler;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service=PracticeScheduledTask.class,immediate=true)
@Designate(ocd=SimpleSchedulerConfiguration.class)
public class PracticeScheduledTask implements Runnable{
	
	static final Logger LOG=LoggerFactory.getLogger(PracticeScheduledTask.class);
	
	@Reference
	Scheduler scheduler;
	
	@Activate
	public void activate(SimpleSchedulerConfiguration config) {
		 LOG.error(" PracticeScheduledTask activate method called");
		 scheduleJob(config);

		
	}
	@Deactivate
	public void deactivate(SimpleSchedulerConfiguration config) {
		removescheduler(config);
		
	}
	
	public void scheduleJob(SimpleSchedulerConfiguration config) {
		 LOG.error("Scheduler added successfully >>>>>>>   ");

		if(config.enable_scheduler()) {
			ScheduleOptions options=scheduler.EXPR(config.scheduler_expression());
			options.canRunConcurrently(config.concurrent_scheduler());
			scheduler.schedule(this, options);
			LOG.error("Scheduler added successfully name='{}'", config.scheduler_name());
		}else {
			
			  LOG.error("SimpleScheduledTask disabled");

		}
	}
	
	public void removescheduler(SimpleSchedulerConfiguration config) {
		scheduler.unschedule(config.scheduler_name());
		
	}
	public void modified(SimpleSchedulerConfiguration config) {
		removescheduler(config);
		scheduleJob(config);
		
	}
	
	

	@Override
	public void run() {
		  LOG.error("PracticeScheduledTask run >>>>>>>>>>>");

		
	}

}
