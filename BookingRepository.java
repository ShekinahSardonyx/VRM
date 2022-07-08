package com.vrm.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vrm.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking,Integer>{
	
	public List<Booking> getByBookingFromDate(LocalDate date);
	public Booking getByBookingId(int id);

}
