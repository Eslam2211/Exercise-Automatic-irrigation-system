package com.example.AutomaticIrrigationSystem.presentation.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AutomaticIrrigationSystem.buisness.exception.SensorNotFoundException;
import com.example.AutomaticIrrigationSystem.buisness.service.SensorService;


@RestController
@RequestMapping("/sensors")
public class SensorRestController {
	
	@Autowired
	private SensorService sensorService;

	@GetMapping("/SensorCall/{id}")
	public String callSensor(@PathVariable("id") Integer id) throws SensorNotFoundException{
		return sensorService.sendRequest(id);
	}
	
	@GetMapping("/Sensoropen")
	public String openSlots(){
		return sensorService.openSlot();
	}
	
	@GetMapping("/Sensorclose")
	public String closeSlots(){
		return sensorService.closeSlot();
	}
	
}



















