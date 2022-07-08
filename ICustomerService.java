package com.vrm.service;

import java.util.List;

import com.vrm.dto.CustomerDto;

public interface ICustomerService {

	public String addCustomer(CustomerDto customerDto);
	public List<CustomerDto> removeCustomer(int id);
	public CustomerDto viewCustomer(int id);
	public CustomerDto updateCustomer(int id,String mobNum);
	public List<CustomerDto> viewAllCustomer();
	public List<CustomerDto> viewAllCustomersByLocation(String location);
}
