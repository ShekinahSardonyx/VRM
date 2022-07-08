package com.vrm.service;

import java.time.LocalDate;
import java.util.List;

import com.vrm.dto.PaymentDto;

public interface IPaymentService {

	public String addPayment(PaymentDto paymentDto);
	public String cancelPayment(int id);
	public PaymentDto updatePaymentMode(int id, String paymentMode);
	public PaymentDto updatePaymentDate(int id, LocalDate paymentDate);
	public PaymentDto viewpayment( int id );
	public List<PaymentDto> viewAllPayments ();
	public String getpaymentStatus(int paymentId);
	public double calculateMonthlyPayment(String type, String role, LocalDate d1, LocalDate d2);
	public double CalculateTotalPayment(String type, LocalDate d1, LocalDate d2);
}
