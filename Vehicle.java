package com.vrm.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Vehicle {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int vehicleId;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinTable(name = "driverVehicle")
	private Driver driver;
	
	@NotNull(message="Vehicle number should not be null")
	private String vehicleNumber;
	
	@Column
	private String type;
	@Column
	private String category;
	@Column
	private String description;
	@Column
	private String location;
	@Column
	private String capacity;
	@Column
	private double chargesPerKm;
	@Column
	private double fixedCharges;
	public Vehicle() {
		
	}
	public Vehicle( Driver driver, String vehicleNumber, String type, String category, String description,
			String location, String capacity, double chargesPerKm, double fixedCharges) {
		super();
		this.driver = driver;
		this.vehicleNumber = vehicleNumber;
		this.type = type;
		this.category = category;
		this.description = description;
		this.location = location;
		this.capacity = capacity;
		this.chargesPerKm = chargesPerKm;
		this.fixedCharges = fixedCharges;
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	public double getChargesPerKm() {
		return chargesPerKm;
	}
	public void setChargesPerKm(double chargesPerKm) {
		this.chargesPerKm = chargesPerKm;
	}
	public double getFixedCharges() {
		return fixedCharges;
	}
	public void setFixedCharges(double fixedCharges) {
		this.fixedCharges = fixedCharges;
	}
	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", vehicleNumber=" + vehicleNumber + ", type=" + type + ", category="
				+ category + ", description=" + description + ", location=" + location + ", capacity=" + capacity
				+ ", chargesPerKm=" + chargesPerKm + ", fixedCharges=" + fixedCharges + "]";
	}
	
	
}
