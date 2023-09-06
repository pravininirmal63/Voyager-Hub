package com.app.service;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Drivers;
import com.app.entity.Routes;
import com.app.entity.Travels;
import com.app.repository.TravelsRepository;

@Service
@Transactional
public class TravelServiceImpl implements TravelService
{
	@Autowired
	private TravelsRepository travelRepo;

	@Override
	public Travels addTravels(Travels travel) {
		
		return travelRepo.save(travel);
	}

	@Override
	public String deleteTravels(Long travel_id) {
		if(travelRepo.existsById(travel_id))
		{
			Travels travels=travelRepo.findById(travel_id).orElseThrow();
			travelRepo.deleteById(travel_id);
			return "Delete successfully";
		}
		return "Not deleted";
	}

	@Override
	public Travels updateeTravels(Travels travel) {
		
		return travelRepo.save(travel);
	}


	@Override
	public List<Travels> getTravelsList() 
	{
		
		return travelRepo.findAll();
	}

	@Override
	public Set<Routes> getRoutesList(Long travel_id)
	{
		
		return travelRepo.findById(travel_id).orElseThrow().getRoutesList();
	}

	@Override
	public Set<Drivers> getDriversList(Long travel_id) {
		
		return travelRepo.findById(travel_id).orElseThrow().getDriverList();
	}
	
	

}
