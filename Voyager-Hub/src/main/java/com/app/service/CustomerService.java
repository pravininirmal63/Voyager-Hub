package com.app.service;

import java.util.List;

import com.app.entity.Customer;

public interface CustomerService 
{
	Customer addCustomer(Customer customer);
	String deleteCustomer(Long cust_id);
	Customer updateCustomer(Customer customer);
	String addToRoutes(Long cust_id);
	List<Customer> getCustomerList();	
	Customer loginCustomer(String email,String password);
}
