package com.vrm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vrm.dto.BookingDto;
import com.vrm.dto.PaymentDto;
import com.vrm.service.IBookingService;
import com.vrm.service.ICustomerService;
import com.vrm.service.IPaymentService;


@RestController
public class AdminCustomerController {

	@Autowired
	public IPaymentService paymentService;

	@Autowired
	public IBookingService bookingService;

	@Autowired
	public ICustomerService customerService;

	@PostMapping("/addPayment")
	public String addPayment(@Valid @RequestBody PaymentDto paymentDto) {
		return paymentService.addPayment(paymentDto);
	}
	
	@PostMapping("/addbooking")
	public BookingDto addBooking(@Valid @RequestBody  BookingDto bookingDto) {
		return bookingService.addBooking(bookingDto);
	}

	@DeleteMapping("/CancelBooking/{id}")
	public String cancelBooking(@PathVariable("id") int bookingId) {
		return bookingService.cancelBooking(bookingId);
	}

	@DeleteMapping("/deletePayment/{paymentId}")
	public String deletePayment(@PathVariable("PaymentId")int paymentId){
		return paymentService.cancelPayment(paymentId);
	}
}
