package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.EmailDTO;
import com.app.entity.Customer;
import com.app.service.CustomerService;

@RestController
@CrossOrigin
@RequestMapping("customer/")
public class CustomerController 
{
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/register")
	public ResponseEntity<?> addCustomer(@RequestBody @Valid Customer customer) {
		return ResponseEntity.status(HttpStatus.OK).body(customerService.addCustomer(customer));
	}
	
	@GetMapping("/CustomerList")
	public ResponseEntity<?> getCustomerList()
	{
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(customerService.getCustomerList());
	}
	
	@PutMapping("/updateCustomer")
	public ResponseEntity<?> updateCustomer(@RequestBody Customer customer)
	{
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(customerService.updateCustomer(customer));

	}
	
	@DeleteMapping("/deleteCustomer/{cust_id}")
	public ResponseEntity<?> deleteCustomer(@RequestParam Long cust_id)
	{
		return ResponseEntity.status(HttpStatus.OK).body(customerService.deleteCustomer(cust_id));
	}
	
	@GetMapping("/CustomerList/{cust_id}")
	public ResponseEntity<?> addRoutes(@RequestParam Long cust_id)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(customerService.addToRoutes(cust_id));
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> loginCustomer(@RequestBody EmailDTO email)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(customerService.loginCustomer(email.getEmail(), email.getPassword()));

	}
	
	
	

}
