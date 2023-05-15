package com.example.AutomaticIrrigationSystem.presentation.Controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AutomaticIrrigationSystem.buisness.exception.PlotNotFoundException;

import com.example.AutomaticIrrigationSystem.buisness.service.PlotOfLandServicelimp;
import com.example.AutomaticIrrigationSystem.persistence.entities.PlotOfland;


@RestController
@RequestMapping("/plotland")
public class PlotoflandRestController {
	
	@Autowired
	private PlotOfLandServicelimp plotService;

	@GetMapping("/")
	public List<PlotOfland> getAllPlots(){
		return plotService.getAllPlots();
	}
	
	@GetMapping("/{id}")
	public PlotOfland getById(@PathVariable("id") Integer id) throws PlotNotFoundException {
		return plotService.getPlotsById(id);
	}
	
	@PostMapping("/add")
	public ResponseEntity<PlotOfland> savePlot(@RequestBody PlotOfland plot) {
		plot.setId(0);
		PlotOfland savedPlot = plotService.savePlot(plot);
		
		return new ResponseEntity<PlotOfland>(savedPlot, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public PlotOfland updatePlot(@RequestBody PlotOfland plot) {
		
		return plotService.savePlot(plot);
	}
	

	@DeleteMapping("/delete/{id}")
	    public ResponseEntity<String> deleteLandPlot(@PathVariable(name = "id") int id) throws PlotNotFoundException {
	
	        plotService.deletePlot(id);
	        return new ResponseEntity<>("Land Plot deleted Successfully", HttpStatus.OK);
	
	    }
	
	
	
}



















