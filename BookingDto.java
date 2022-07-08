package com.vrm.dto;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

import com.vrm.entity.Customer;
import com.vrm.entity.Vehicle;

@Component
public class BookingDto {

	private int bookingId;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinTable(name="customerBooking")
	private Customer customer;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinTable(name = "vehicleBooking")
	private Vehicle vehicle;
	
	private LocalDate bookingDate;
	
	private LocalDate bookedTillDate;
	
	private String bookingDescription;
	
	private double totalCost;
	
	private double distance;
	
    public BookingDto(){}

	public BookingDto(int bookingId, Customer customer, Vehicle vehicle, LocalDate bookingDate, LocalDate bookedTillDate,
			String bookingDescription, double totalCost, double distance) {
		super();
		this.bookingId = bookingId;
		this.customer = customer;
		this.vehicle = vehicle;
		this.bookingDate = bookingDate;
		this.bookedTillDate = bookedTillDate;
		this.bookingDescription = bookingDescription;
		this.totalCost = totalCost;
		this.distance = distance;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public LocalDate getBookedTillDate() {
		return bookedTillDate;
	}

	public void setBookedTillDate(LocalDate bookedTillDate) {
		this.bookedTillDate = bookedTillDate;
	}

	public String getBookingDescription() {
		return bookingDescription;
	}

	public void setBookingDescription(String bookingDescription) {
		this.bookingDescription = bookingDescription;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "BookingDto [bookingId=" + bookingId + ", customer=" + customer + ", vehicle=" + vehicle
				+ ", bookingDate=" + bookingDate + ", bookedTillDate=" + bookedTillDate + ", bookingDescription="
				+ bookingDescription + ", totalCost=" + totalCost + ", distance=" + distance + "]";
	}
	
	
}
