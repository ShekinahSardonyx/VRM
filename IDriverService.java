package com.vrm.service;

import java.util.List;

import com.vrm.dto.DriverDto;

public interface IDriverService {

	public DriverDto addDriver(DriverDto driverDto);
	public List<DriverDto> removeDriver(int id);
	public DriverDto updateDriver(int id, String mobNum);
	public String AcceptOrRejectBooking(String message);
}
