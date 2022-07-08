package com.vrm.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vrm.dto.BookingDto;
import com.vrm.dto.CustomerDto;
import com.vrm.dto.PaymentDto;
import com.vrm.dto.VehicleDto;
import com.vrm.service.IBookingService;
import com.vrm.service.ICustomerService;
import com.vrm.service.IPaymentService;
import com.vrm.service.IVehicleService;

@RestController
public class AdminController {

	
	@Autowired
	private IVehicleService vehicleService;
	
	
	@Autowired
    public ICustomerService customerService;
	
	@Autowired
	public IPaymentService paymentService;
	
	@Autowired
	private IBookingService bookingService;
	
	
	@PostMapping("/addVehicle")
	public String addVehicle(@Valid @RequestBody VehicleDto vehicleDto) {
		return vehicleService.addVehicle(vehicleDto);
	}
	
	@PutMapping("/updateVehicle/{id}/{type}")
	public VehicleDto updateVehicle(@PathVariable("id") int vId, @PathVariable("type") String newType) {
		return vehicleService.updateVehicle(vId, newType);
	}
	
	@DeleteMapping("/deleteVehicle/{id}")
	public List<VehicleDto> deleteVehicle(@PathVariable("id") int vId){
		return vehicleService.deleteVehicle(vId);
	}
    
    @PostMapping("/addCustomer/{customer}")
	public String addCustomer(@Valid @RequestBody CustomerDto customerDto) {
		return customerService.addCustomer(customerDto);
		
	}
	@PutMapping("/update/{customerId}/{customerMobileNumber}")
	public CustomerDto updateCustomer(@PathVariable("customerId") int customerId,@PathVariable("customerMobileNumber") String customerMobileNumber){
		return customerService.updateCustomer(customerId, customerMobileNumber);
	}
	
	@DeleteMapping("/deleteCustomer/{customerId}")
	public List<CustomerDto> deleteCustomer(@PathVariable ("customerId") int customerId) {
		return customerService.removeCustomer(customerId);
	}
	
	
	@GetMapping("/ViewAllCustomers")
	public List<CustomerDto> ViewAllCustomers() {
		return customerService.viewAllCustomer();
	}
	
	@GetMapping("/getAllCustomersByAddress/{Address}")
	public List<CustomerDto> getAllCustomersByLocation(String location){
		return customerService.viewAllCustomersByLocation(location);
	}
	

	@PutMapping("/update/{paymentId}/{mode}")
	public PaymentDto updatePaymentMode(@PathVariable("paymentId")int paymentId, @PathVariable("mode") String mode){
		return paymentService.updatePaymentMode(paymentId, mode);
	}
	
	@PutMapping("/update/{paymentId}/{date}")
	public PaymentDto updatePaymentDate(@PathVariable("paymentId")int paymentId,@RequestParam(value="date") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate date){
		return paymentService.updatePaymentDate(paymentId, date);
	}
	
	@GetMapping("/viewAllPayments")
	public List<PaymentDto> ViewAllPayments(){
		return paymentService.viewAllPayments();
   }

	@GetMapping("/calculateTotalPayment/{type}/{date1}/{date2}")
	public double calculateTotalPay(@PathVariable("type") String type , @RequestParam(value="date1") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate date1, @RequestParam(value="date2") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate date2) {
		return paymentService.CalculateTotalPayment(type, date1, date2);
	}
	
	
	@PutMapping("/updateByDate/{id}/{date}")
	public BookingDto updateBookingFromDate(@PathVariable ("id") int bookingId,@RequestParam(value="date") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate bookingFromDate) {
		return bookingService.updateBookingFromDate(bookingId, bookingFromDate);
		
	}


	@PutMapping("/updateByTillDate/{id}/{date}")
	public BookingDto updateBookingTillDate(@PathVariable ("id") int bookingId,@RequestParam(value="date") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate bookedTillDate) {
		return bookingService.updateBookingTillDate(bookingId, bookedTillDate);
		
	}

	@PutMapping("/updateDistance/{id}/{distance}")
	public BookingDto updatedistance(@PathVariable ("id") int bookingId,@PathVariable("distance") double distance) {
		return bookingService.updatedistance(bookingId, distance);
		
	}

	@PutMapping("/updateCost/{id}/{cost}")
	public BookingDto updatecost(@PathVariable ("id") int bookingId,@PathVariable("cost") double totalcost) {
		return bookingService.updatecost(bookingId, totalcost);
		
	}
	
    @GetMapping("/viewAllBooking")
    public List<BookingDto> viewAllBooking() {
    	return bookingService.viewAllBookings();
    }
    
    
    @GetMapping("/viewAllBookingByDate/{date}")
    public List<BookingDto> viewAllBookingByDate(@RequestParam(value="date") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate bookingDate) {
    	return bookingService.viewAllBookingByDate(bookingDate);
    }
    
    @GetMapping("/ChargesPerKm/{id}/{type}")
    public double chargesPerKm(@PathVariable("id") int id, @PathVariable("type") String type) {
    	return vehicleService.chargesPerKm(id, type);
    }
    
}
