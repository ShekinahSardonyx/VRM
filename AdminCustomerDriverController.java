package com.vrm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.vrm.dto.BookingDto;
import com.vrm.dto.CustomerDto;
import com.vrm.service.IBookingService;
import com.vrm.service.ICustomerService;
import com.vrm.service.IPaymentService;


@RestController
public class AdminCustomerDriverController {

	@Autowired
	public IBookingService bookingService;
	
	@Autowired
	public IPaymentService paymentService;
	
	@Autowired
	public ICustomerService customerService;
	
	@GetMapping("/viewBooking/{id}")
    public BookingDto viewBooking(@PathVariable ("id") int bookingId) {
    	return bookingService.viewBooking(bookingId);
    }
	
	@GetMapping("/ViewPaymentStatus/{paymentId}")
	public String viewPaymentStatus(@PathVariable("paymentId") int paymentId) {
		return paymentService.getpaymentStatus(paymentId);
	}
	
	@GetMapping("/ViewCustomer/{customerId}")
	public CustomerDto viewCustomer(@PathVariable("customerId") int customerId) {
		return customerService.viewCustomer(customerId);
	}
}
