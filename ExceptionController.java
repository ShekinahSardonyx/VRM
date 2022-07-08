package com.vrm.exceptionController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.vrm.exception.BookingNotFoundException;
import com.vrm.exception.CustomerNotFoundException;
import com.vrm.exception.DriverNotFoundException;
import com.vrm.exception.PaymentNotFoundException;
import com.vrm.exception.UserNotFoundException;
import com.vrm.exception.VehicleNotFoundException;




@ControllerAdvice
public class ExceptionController {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ExceptionHandler(value= BookingNotFoundException.class)
	public ResponseEntity<Object> bookingCodeExceptionHandler(Exception ex){
		return new ResponseEntity("Booking Not Found", HttpStatus.NOT_FOUND);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ExceptionHandler(value= CustomerNotFoundException.class)
	public ResponseEntity<Object> customerCodeExceptionHandler(Exception ex){
		return new ResponseEntity("Customer Not Found", HttpStatus.NOT_FOUND);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ExceptionHandler(value= DriverNotFoundException.class)
	public ResponseEntity<Object> driverCodeExceptionHandler(Exception ex){
		return new ResponseEntity("Driver Not Found", HttpStatus.NOT_FOUND);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ExceptionHandler(value= PaymentNotFoundException.class)
	public ResponseEntity<Object> paymentCodeExceptionHandler(Exception ex){
		return new ResponseEntity("Payment Not Found", HttpStatus.NOT_FOUND);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ExceptionHandler(value= UserNotFoundException.class)
	public ResponseEntity<Object> userCodeExceptionHandler(Exception ex){
		return new ResponseEntity("User Not Found", HttpStatus.NOT_FOUND);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ExceptionHandler(value= VehicleNotFoundException.class)
	public ResponseEntity<Object> vehicleCodeExceptionHandler(Exception ex){
		return new ResponseEntity("Admin Not Found", HttpStatus.NOT_FOUND);
	}
}