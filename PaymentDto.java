package com.vrm.dto;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

import com.vrm.entity.Booking;

@Component
public class PaymentDto {

	private int paymentId;
	
	private String paymentMode;

	private LocalDate paymentDate;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinTable(name = "bookingPayment")
	private Booking booking;

	
	public PaymentDto() {};
	public PaymentDto(int paymentId, String paymentMode, LocalDate paymentDate, Booking booking) {
		super();
		this.paymentId = paymentId;
		this.paymentMode = paymentMode;
		this.paymentDate = paymentDate;
		this.booking = booking;
	}
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	@Override
	public String toString() {
		return "PaymentDto [paymentId=" + paymentId + ", paymentMode=" + paymentMode + ", paymentDate=" + paymentDate
				+ ", booking=" + booking + "]";
	}
	
	
	
}
