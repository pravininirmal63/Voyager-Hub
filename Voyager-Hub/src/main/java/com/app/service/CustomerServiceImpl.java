package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.appException.AppException;
import com.app.entity.Customer;
import com.app.entity.Routes;
import com.app.repository.CustomerRepository;
import com.app.repository.RoutesRepository;

@Service
@Transactional

public class CustomerServiceImpl implements CustomerService
{
	@Autowired
	private CustomerRepository customerRepo;
	@Autowired 
	private ModelMapper mapper ;
	@Autowired
	private RoutesRepository routeRepo;
	

	@Override
	public Customer addCustomer(Customer customer) 
	{
		System.out.println(customer);
		return customerRepo.save(customer);
	}

	@Override
	public String deleteCustomer(Long cust_id) 
	{
		if(customerRepo.existsById(cust_id))
		{
//			Customer customer=customerRepo.findById(cust_id).orElseThrow();
			customerRepo.deleteById(cust_id);
			return "Delete Successfully";
		}
		return "Delete Unsuccessfully";
	}

	@Override
	public Customer updateCustomer(Customer customer) 
	{
		return customerRepo.save(customer);
	}

	@Override
	public String addToRoutes(Long cust_id) 
	{
		if(customerRepo.existsById(cust_id))
		{
			Customer customer=customerRepo.findById(cust_id).orElseThrow();
			Routes route=routeRepo.findById(customer.getRoute().getId()).orElseThrow();
			route.addCustomer(customer);
			return "Add to travels";
		}
		return "Not add to travels";
	}

	@Override
	public List<Customer> getCustomerList() 
	{	
		return customerRepo.findAll();
	}

	@Override
	public Customer loginCustomer(String email, String password) {
		
		return customerRepo.findByEmailAndPassword(email, password);
	}
	

}
