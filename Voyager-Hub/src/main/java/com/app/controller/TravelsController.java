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
import com.app.entity.Travels;
import com.app.service.TravelService;

@RestController
@CrossOrigin
@RequestMapping("travel/")
public class TravelsController 
{
	@Autowired
	private TravelService travelsService;
	
	@PostMapping("/register")
	public ResponseEntity<?> addTravels(@RequestBody @Valid Travels travel) {
		return ResponseEntity.status(HttpStatus.OK).body(travelsService.addTravels(travel));
	}
	
	@GetMapping("/getTravelsList")
	public ResponseEntity<?> getDriverList()
	{
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(travelsService.getTravelsList());
	}
	
	@PutMapping("/updateTravels")
	public ResponseEntity<?> updateDriver(@RequestBody Travels travel)
	{
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(travelsService.updateeTravels(travel));

	}
	
	@DeleteMapping("/deleteDriver/{travel_id}")
	public ResponseEntity<?> deleteCustomer(@RequestParam Long travel_id)
	{
		return ResponseEntity.status(HttpStatus.OK).body(travelsService.deleteTravels(travel_id));
	}


}
