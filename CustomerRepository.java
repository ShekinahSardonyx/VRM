package com.vrm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vrm.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	
	public List<Customer> getByCustomerAddress(String location);

}

