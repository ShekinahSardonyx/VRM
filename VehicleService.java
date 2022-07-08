package com.vrm.serviceimpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vrm.dto.VehicleDto;
import com.vrm.entity.Vehicle;
import com.vrm.exception.VehicleNotFoundException;
import com.vrm.repository.BookingRepository;
import com.vrm.repository.VehicleRepository;
import com.vrm.service.IVehicleService;

@Service
public class VehicleService implements IVehicleService{
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Autowired
	private BookingRepository bookingRepository;

	Vehicle vehicle = new Vehicle();

	public String addVehicle(VehicleDto vehicleDto) {
		Vehicle vehicle = new Vehicle();
		BeanUtils.copyProperties(vehicleDto, vehicle);
		vehicleRepository.save(vehicle);
		return "Vehicle Added Successfully";
	}
	
	public VehicleDto updateVehicle(int vId, String type) {
		Vehicle vehicle = new Vehicle();
		VehicleDto vehicleDto = new VehicleDto();
		if(vehicleRepository.findById(vId)==null) {
			throw new VehicleNotFoundException();
		}
		else {
			BeanUtils.copyProperties(vehicleRepository.findById(vId), vehicleDto);
			vehicleDto.setType(type);
			BeanUtils.copyProperties(vehicle, vehicleDto);
			vehicleRepository.flush();
			return vehicleDto;
		}
	}
	
	public List<VehicleDto> deleteVehicle(int vId){
		
		vehicleRepository.deleteById(vId);
		VehicleDto vehicleDto = new VehicleDto();
		List<VehicleDto> vehicleDtoList = new ArrayList<>();
		if(vehicleRepository.findAll()==null) {
			throw new VehicleNotFoundException();
		}
		else {
			List<Vehicle> vehicleList = vehicleRepository.findAll();
			for(Vehicle vehicle : vehicleList) {
				BeanUtils.copyProperties(vehicle, vehicleDto);
				vehicleDtoList.add(vehicleDto);
			}
			return vehicleDtoList;
		}
	}
	
	public double fixedChargesForCar(LocalDate d1, LocalDate d2) {
		double perDayCost = 1000.0;
		Long numOfDays = ChronoUnit.DAYS.between(d1,d2);
		return perDayCost*numOfDays;
	}
	
	public double fixedChargesForBike(LocalDate d1, LocalDate d2) {
		double perDayCost = 300.0;
		Long numOfDays = ChronoUnit.DAYS.between(d1,d2);
		return perDayCost*numOfDays;
	}
	
	public double fixedChargesForBicycle(LocalDate d1, LocalDate d2) {
		double perDayCost = 150.0;
		Long numOfDays = ChronoUnit.DAYS.between(d1,d2);
		return perDayCost*numOfDays;
	}
	
	public double chargesPerKm(int id, String type) {
		double d1 =0.0;
		if(type.equals("Car")) {
			double distance = bookingRepository.getByBookingId(id).getDistance();
			double costPerKm = 25.0;
			d1 = costPerKm * distance;
		}
		else if(type.equals("Bike")) {
			double distance = bookingRepository.getByBookingId(id).getDistance();
			double costPerKm = 10.0;
			d1 = costPerKm * distance;
		}
		else if(type.equals("Bicycle")) {
			double distance = bookingRepository.getByBookingId(id).getDistance();
			double costPerKm = 5.0;
			d1 = costPerKm * distance;
		}
		return d1;
	}
	
		
}
