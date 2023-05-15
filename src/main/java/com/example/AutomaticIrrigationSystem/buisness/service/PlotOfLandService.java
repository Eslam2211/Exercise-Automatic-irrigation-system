package com.example.AutomaticIrrigationSystem.buisness.service;

import java.util.List;

import com.example.AutomaticIrrigationSystem.buisness.exception.PlotNotFoundException;
// import com.example.AutomaticIrrigationSystem.persistence.dao.entities.PlotOfland;
import com.example.AutomaticIrrigationSystem.persistence.entities.PlotOfland;

public interface PlotOfLandService {

    public List<PlotOfland> getAllPlots();

    public PlotOfland getPlotsById(Integer id) throws PlotNotFoundException;

    public PlotOfland savePlot(PlotOfland plot) ;
    
    public void calculatePlotData(PlotOfland plot);


  public void deletePlot(Integer id) throws PlotNotFoundException ;

}
