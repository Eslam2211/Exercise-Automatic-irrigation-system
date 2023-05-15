package com.example.AutomaticIrrigationSystem.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "crops")
public class Crop {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "plant_type", length = 128, nullable = false, unique = true)
	private String type;
	
	@Column(name = "irrigation_delay", nullable = false)
	private int irrigationDelay;
	
	@Column(name = "irrigation_duration", nullable = false)
	private int irrigationDuration;
	
	@Column(name = "water_amount", nullable = false)
	private double waterAmount;

	public Crop() {
	}

	public Crop(Integer id) {
		this.id = id;
	}
	
	public Crop(String type, int irrigationDelay, int irrigationDuration, double waterAmount) {
		this.type = type;
		this.irrigationDelay = irrigationDelay;
		this.irrigationDuration = irrigationDuration;
		this.waterAmount = waterAmount;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getIrrigationDelay() {
		return irrigationDelay;
	}

	public void setIrrigationDelay(int irrigationDelay) {
		this.irrigationDelay = irrigationDelay;
	}

	public int getIrrigationDuration() {
		return irrigationDuration;
	}

	public void setIrrigationDuration(int irrigationDuration) {
		this.irrigationDuration = irrigationDuration;
	}

	public double getWaterAmount() {
		return waterAmount;
	}

	public void setWaterAmount(double waterAmount) {
		this.waterAmount = waterAmount;
	}

	
}
