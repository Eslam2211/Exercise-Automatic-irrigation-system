package com.example.AutomaticIrrigationSystem.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "plots")
public class PlotOfland {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "area", nullable = false)
	private double area;
	
	@Column(name = "water_amount", nullable = false)
	private double waterAmount;
	
	@Column(name="delay", nullable = false)
	private int delay;
	
	@Column(name = "slot")
	private boolean slot;

	@OneToOne
	@JoinColumn(name = "crop_id")
	private Crop crop;
	

	public PlotOfland() {
	}

	public PlotOfland(Crop crop, double area) {
		this.crop = crop;
		this.area = area;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Crop getCrop() {
		return crop;
	}

	public void setCrop(Crop crop) {
		this.crop = crop;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public double getWaterAmount() {
		return waterAmount;
	}

	public void setWaterAmount(double waterAmount) {
		this.waterAmount = waterAmount;
	}


	public int getDelay() {
		return delay;
	}

	public void setDelay(int delay) {
		this.delay = delay;
	}


	public boolean isSlot() {
		return slot;
	}

	public void setSlot(boolean slot) {
		this.slot = slot;
	}



}

