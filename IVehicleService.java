package com.vrm.service;

import java.time.LocalDate;
import java.util.List;

import com.vrm.dto.VehicleDto;

public interface IVehicleService {

	public String addVehicle(VehicleDto vehicleDto);
	public VehicleDto updateVehicle(int vId, String type);
	public List<VehicleDto> deleteVehicle(int vId);
	public double fixedChargesForCar(LocalDate d1, LocalDate d2);
	public double fixedChargesForBike(LocalDate d1, LocalDate d2);
	public double fixedChargesForBicycle(LocalDate d1, LocalDate d2);
	public double chargesPerKm(int id, String type);
}
