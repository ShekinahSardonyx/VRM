package com.vrm.serviceimpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vrm.dto.BookingDto;
import com.vrm.entity.Booking;
import com.vrm.exception.BookingNotFoundException;
import com.vrm.repository.BookingRepository;
import com.vrm.service.IBookingService;

@Service
public class BookingService implements IBookingService{
	
  @Autowired
	private BookingRepository  bookingRepository; 
	  
		     public BookingDto addBooking(BookingDto bookingDto) 
		     {
		    	 Booking booking = new Booking();
		    	 BeanUtils.copyProperties(bookingDto, booking);
		    	 bookingRepository.save(booking);
		    	 return bookingDto;
		   	           
		     }
			
			
		       
		    public BookingDto updateBookingFromDate(int id,LocalDate date)
		    {
		    	   Booking booking= new Booking();
		    	   BookingDto bookingDto = new BookingDto();
		    	   if(bookingRepository.getByBookingId(id)== null) {
		    		   throw new BookingNotFoundException();
		    	   }
		    	   else {
			    	   BeanUtils.copyProperties(bookingRepository.getByBookingId(id), bookingDto);
			    	   bookingDto.setBookingDate(date);
			    	   BeanUtils.copyProperties(bookingDto, booking);
			    	   bookingRepository.flush();
			    	   return bookingDto;
		    	   }
		          
		    }
		       
		       
		    public BookingDto updateBookingTillDate(int id,LocalDate tilldate)
		    {
		    	   Booking booking= new Booking();
		    	   BookingDto bookingDto = new BookingDto();
		    	   if(bookingRepository.getByBookingId(id)== null) {
		    		   throw new BookingNotFoundException();
		    	   }
		    	   else {
			    	   BeanUtils.copyProperties(bookingRepository.getByBookingId(id), bookingDto);
			    	   bookingDto.setBookedTillDate(tilldate);
			    	   BeanUtils.copyProperties(bookingDto, booking);
			    	   bookingRepository.flush();
			    	   return bookingDto;
		    	   }
		           
		    }
		       
		       
		    public BookingDto updatedistance(int id,double distance)
		    {
		    	   Booking booking= new Booking();
		    	   BookingDto bookingDto = new BookingDto();
		    	   if(bookingRepository.getByBookingId(id)== null) {
		    		   throw new BookingNotFoundException();
		    	   }
		    	   else {
			    	   BeanUtils.copyProperties(bookingRepository.getByBookingId(id), bookingDto);
			    	   bookingDto.setDistance(distance);
			    	   BeanUtils.copyProperties(bookingDto, booking);
			    	   bookingRepository.flush();
			    	   return bookingDto;
		    	   }
		          
		    }
		       
		       
		    public BookingDto updatecost(int id,double cost)
		    {
		    	   Booking booking= new Booking();
		    	   BookingDto bookingDto = new BookingDto();
		    	   if(bookingRepository.getByBookingId(id)== null) {
		    		   throw new BookingNotFoundException();
		    	   }
		    	   else {
			    	   BeanUtils.copyProperties(bookingRepository.getByBookingId(id), bookingDto);
			    	   bookingDto.setTotalCost(cost);
			    	   BeanUtils.copyProperties(bookingDto, booking);
			    	   bookingRepository.flush();
			    	   return bookingDto;
		    	   }
		           
		    }
		       
			
		       
			public String cancelBooking(int id)
			{
				bookingRepository.deleteById(id);
				return " Booking cancelled Successfully";
			}
		
		       
			public BookingDto viewBooking(int id)
			{       
			
				if(bookingRepository.getByBookingId(id)== null) {
		    		   throw new BookingNotFoundException();
		    	   }
				else {
					Booking booking = bookingRepository.getByBookingId(id);
					BookingDto bookingDto = new BookingDto();
					BeanUtils.copyProperties(booking, bookingDto);
					return bookingDto;
				}
				
			}
			
			
			public List<BookingDto> viewAllBookings()
			{
				BookingDto bookingDto = new BookingDto();
				List<BookingDto> bookingDtoList = new ArrayList<>();
				if(bookingRepository.findAll()==null) {
					 throw new BookingNotFoundException();
				}
				else {
					List<Booking> bookingList = bookingRepository.findAll();
					for(Booking booking : bookingList) {
						BeanUtils.copyProperties(booking, bookingDto);
						bookingDtoList.add(bookingDto);
					}
					return bookingDtoList;
				}
			}
		
			
			public List<BookingDto> viewAllBookingByDate(LocalDate bdate)
			{
				if(bookingRepository.getByBookingFromDate(bdate)==null) {
					throw new BookingNotFoundException();
				}
				else {
					List<Booking> bookingList = bookingRepository.getByBookingFromDate(bdate);
					List<BookingDto> bookingDtoList = new ArrayList<>();
					BookingDto bookingDto = new BookingDto();
					for(Booking booking : bookingList) {
						BeanUtils.copyProperties(booking, bookingDto);
						bookingDtoList.add(bookingDto);
					}
					return bookingDtoList;
				}
			}
}
