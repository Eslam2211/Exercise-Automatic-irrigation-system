package com.example.AutomaticIrrigationSystem.persistence.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "irrigation")
public class Irrigation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	
	
	@Column(name = "irrigated")
	private boolean irrigated;
	
	@Column(name = "irrigated_date")
	@CreationTimestamp
	private LocalDateTime irrigatedDate;

	@ManyToOne
	@JoinColumn(name = "plot_id")
	private PlotOfland plot;

	public Irrigation() {
	}

	public Irrigation(PlotOfland plot, boolean irrigated) {
		this.plot = plot;
		this.irrigated = irrigated;
	}

	

	public Irrigation(PlotOfland plot, boolean irrigated, LocalDateTime irrigatedDate) {
		this.plot = plot;
		this.irrigated = irrigated;
		this.irrigatedDate = irrigatedDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PlotOfland getPlot() {
		return plot;
	}

	public void setPlot(PlotOfland plot) {
		this.plot = plot;
	}


	public boolean isIrrigated() {
		return irrigated;
	}

	public void setIrrigated(boolean irrigated) {
		this.irrigated = irrigated;
	}

	public LocalDateTime getIrrigatedDate() {
		return irrigatedDate;
	}

	public void setIrrigatedDate(LocalDateTime irrigatedDate) {
		this.irrigatedDate = irrigatedDate;
	}


	
	
}
