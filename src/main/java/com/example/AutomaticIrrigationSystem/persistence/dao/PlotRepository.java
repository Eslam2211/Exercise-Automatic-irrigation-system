package com.example.AutomaticIrrigationSystem.persistence.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.AutomaticIrrigationSystem.buisness.service.PlotOfLandService;

import com.example.AutomaticIrrigationSystem.persistence.entities.Crop;
import com.example.AutomaticIrrigationSystem.persistence.entities.PlotOfland;


@Repository
public interface PlotRepository extends JpaRepository<PlotOfland, Integer> {

	public Optional<List<PlotOfLandService>> findByCrop(Crop crop);

	@Modifying
	@Query("UPDATE PlotOfland p SET p.slot = ?2 WHERE p.id = ?1")
	public void updateSlotStatus(Integer id, boolean status);

}
