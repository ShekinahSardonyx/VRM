package com.vrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vrm.entity.Payment;


public interface PaymentRepository extends JpaRepository <Payment , Integer>{
	
	public Payment getByPaymentId(int id);
    
}

