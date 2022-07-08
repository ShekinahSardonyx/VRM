package com.vrm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vrm.dto.DriverDto;
import com.vrm.service.IBookingService;
import com.vrm.service.IDriverService;
import com.vrm.service.IPaymentService;

@RestController
public class DriverController {

	@Autowired 
	public IDriverService driverService;
	@Autowired
	public IBookingService bookingService;
	@Autowired
	public IPaymentService paymentService;
	
	@PostMapping("/addDriver")
	public DriverDto addDriver(@Valid @RequestBody DriverDto driverDto) {
		return driverService.addDriver(driverDto);
	}	
	@PutMapping("/updateDriverNum/{id}/{PhNo}")
	public DriverDto updateDriverNumber(@PathVariable("id") int id,@PathVariable("PhNo") String phonenNum) {
		return driverService.updateDriver(id, phonenNum);
	}
	
	@DeleteMapping("/deleteDriver/{id}")
	public List<DriverDto> deleteDriver(@PathVariable("id") int id){
		return driverService.removeDriver(id);
	}
	
	
	@GetMapping("/acceptOrReject/{typeResponse}")
	public String AcceptOrRejectBooking(@PathVariable("typeResponse") String Response) {
		return driverService.AcceptOrRejectBooking(Response);
	}
	
}
