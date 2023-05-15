package com.example.AutomaticIrrigationSystem.buisness.service;



import java.util.logging.Logger;

import org.springframework.retry.annotation.Retryable;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Service;

import com.example.AutomaticIrrigationSystem.buisness.exception.SensorNotFoundException;

@Service
public class SensorService {
	static final Logger LOGGER = Logger.getLogger(SensorService.class.getName());
	
	@Retryable(value = {SensorNotFoundException.class}, maxAttempts = 10, backoff = @Backoff(delay = 2000))
	public String sendRequest(Integer plotId) throws SensorNotFoundException {
		
		if(Math.random() < .5) {
			LOGGER.warning("Retry to connect to sensor again ");
			throw new SensorNotFoundException("Sensor is not availabe now");
		}
		return " the sensor from Plot " + plotId + " " +" Sent irrigate request ";
	}
	

	public String openSlot() {
		return "Slot is opened ";
	}


	public String closeSlot() {
		return "Slot is closed ";
	}

}
