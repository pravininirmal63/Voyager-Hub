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
import com.app.entity.Routes;
import com.app.service.RoutesService;

@RestController
@CrossOrigin
@RequestMapping("route/")
public class RoutesController 
{
	@Autowired
	private RoutesService routeService;
	

	@PostMapping("/register")
	public ResponseEntity<?> addRoute(@RequestBody @Valid Routes route) {
		return ResponseEntity.status(HttpStatus.OK).body(routeService.addRoute(route));
	}
	
	@GetMapping("/RoutesList")
	public ResponseEntity<?> getRoutesList()
	{
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(routeService.getRoutesList());
	}
	
	@PutMapping("/updateCustomer")
	public ResponseEntity<?> updateRoute(@RequestBody Routes route)
	{
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(routeService.updateRoute(route));

	}
	
	@DeleteMapping("/deleteCustomer/{cust_id}")
	public ResponseEntity<?> deleteRoute(@RequestParam Long route_id)
	{
		return ResponseEntity.status(HttpStatus.OK).body(routeService.deleteRoute(route_id));
	}
	
	@GetMapping("/CustomerList/{route_d}/{travels_id}")
	public ResponseEntity<?> addToTravels(@RequestParam Long route_d,@RequestParam Long travels_id)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(routeService.addToTravels(route_d, travels_id));
	}
}
