package com.example.AutomaticIrrigationSystem.config;



import java.util.List;
import java.util.logging.Logger;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;

import com.example.AutomaticIrrigationSystem.buisness.service.PlotOfLandServicelimp;

import com.example.AutomaticIrrigationSystem.persistence.entities.PlotOfland;

import jakarta.annotation.PostConstruct;

@Component
public class IrrigationConfig {
	static final Logger LOGGER = Logger.getLogger(IrrigationConfig.class.getName());
	
	@Autowired
	private ThreadPoolTaskScheduler Scheduler;
	
	@Autowired
	private PlotOfLandServicelimp plotService;
	

	private void executeIrrigation(PlotOfland plot) throws InterruptedException {
		Scheduler.scheduleWithFixedDelay(new SensorRunnable(plot), plot.getDelay()*2000);
	}
	
	@PostConstruct
	public void automateIrrigationSystem() {
		
		List<PlotOfland> plots = plotService.getAllPlots();
		
		plots.forEach((plot) -> {
			try {
				executeIrrigation(plot);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
	}
	
	private void sensorIrrigatePlot(PlotOfland plot) throws InterruptedException {
		
		 sendRequestToSensor(plot);
		 updateSlotToOpen(plot);
		sleepForIrrigationDuration(plot);
		updateSlotToClose(plot);
	
	}
	
	public String sendRequestToSensor(PlotOfland plot) {
		 String msg = plotService.sendRequestToSensor(plot);
		 LOGGER.info(msg);
		 return msg;
	}

	public String updateSlotToClose(PlotOfland plot) {
		String close = plotService.closeSlot();
		plotService.updateSlotStatus(plot.getId(), false);
		LOGGER.info(close);
		return close;
	}
	

	public String updateSlotToOpen(PlotOfland plot) {
		String open = plotService.openSlot();
		plotService.updateSlotStatus(plot.getId(), true);
		LOGGER.info(open);
		return open;
	}
	
	public void sleepForIrrigationDuration(PlotOfland plot) throws InterruptedException {
		long durationInMilli = plot.getCrop().getIrrigationDuration() * 2000;
		Thread.sleep(durationInMilli);
	}

	
	
	class SensorRunnable implements Runnable {
		
		
		private PlotOfland plot;
		
		public SensorRunnable(PlotOfland plot) {
			this.plot = plot;
		}

		

		@Override
		public void run() {
			
			try {
				sensorIrrigatePlot(plot);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}
}
