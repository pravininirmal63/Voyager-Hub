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
import com.app.entity.Drivers;
import com.app.service.DriverService;

@RestController
@CrossOrigin
@RequestMapping("driver/")
public class DriversController 
{
	@Autowired
	private DriverService driverService;


	@PostMapping("/register")
	public ResponseEntity<?> addDriver(@RequestBody @Valid Drivers driver) {
		return ResponseEntity.status(HttpStatus.OK).body(driverService.addDriver(driver));
	}
	
	@GetMapping("/getDriverList")
	public ResponseEntity<?> getDriverList()
	{
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(driverService.getDriverList());
	}
	
	@PutMapping("/updateDriver")
	public ResponseEntity<?> updateDriver(@RequestBody Drivers driver)
	{
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(driverService.updateDriver(driver));

	}
	
	@DeleteMapping("/deleteDriver/{driver_id}")
	public ResponseEntity<?> deleteCustomer(@RequestParam Long driver_id)
	{
		return ResponseEntity.status(HttpStatus.OK).body(driverService.deleteDriver(driver_id));
	}
	
	@GetMapping("/CustomerList/{cust_id}/{travels_id}")
	public ResponseEntity<?> addRoutes(@RequestParam Long driver_id,@RequestParam Long travels_id)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(driverService.addToTravels(driver_id, travels_id));
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> loginDriver(@RequestBody EmailDTO email)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(driverService.loginDriver(email.getEmail(), email.getPassword()));

	}
}
