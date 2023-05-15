package com.example.AutomaticIrrigationSystem.buisness.service;



import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.example.AutomaticIrrigationSystem.buisness.exception.PlotNotFoundException;
import com.example.AutomaticIrrigationSystem.persistence.dao.PlotRepository;
import com.example.AutomaticIrrigationSystem.persistence.entities.PlotOfland;



@Service
@Transactional
public class PlotOfLandServicelimp implements  PlotOfLandService {

	 @Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private PlotRepository plotRepository;

	public List<PlotOfland> getAllPlots(){
		return plotRepository.findAll();
	}
	
	public PlotOfland getPlotsById(Integer id) throws PlotNotFoundException {
		return plotRepository.findById(id).orElseThrow(() -> new PlotNotFoundException("No plot found with Id : " + id));
	}
	
	public PlotOfland savePlot(PlotOfland plot) {
		calculatePlotData(plot);
		
		return plotRepository.save(plot);
	}
	
	public void deletePlot(Integer id) throws PlotNotFoundException {
		plotRepository.findById(id).orElseThrow(() -> new PlotNotFoundException("No plot found with Id : " + id));
		plotRepository.deleteById(id);
	}
	
	@Override
	public void calculatePlotData(PlotOfland plot) {
		plot.setWaterAmount(plot.getCrop().getWaterAmount() * plot.getArea());
		plot.setDelay(plot.getCrop().getIrrigationDelay());
	}


	public void updateSlotStatus(Integer id, boolean status) {
		plotRepository.updateSlotStatus(id, status);
	}
	
	public String sendRequestToSensor(PlotOfland plot) {
		String url = "http://localhost:9095/sensors/SensorCall/{id}";
		Map<String, String> params = new HashMap<>();
		params.put("id", plot.getId().toString());
		
		String message = restTemplate.getForObject(url, String.class, params);
		return message;
	}
	
	public String openSlot() {
		String url = "http://localhost:9095/sensors/Sensoropen";
		RestTemplate template = new RestTemplate();
		
		String message = template.getForObject(url, String.class);
		
		return message;
	}


	public String closeSlot() {
		String url = "http://localhost:9095/sensors/Sensorclose";
		RestTemplate template = new RestTemplate();
		String message = template.getForObject(url, String.class);
		return message;
	}

	

}

