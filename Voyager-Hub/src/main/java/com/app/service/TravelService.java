package com.app.service;

import java.util.List;
import java.util.Set;

import com.app.entity.Drivers;
import com.app.entity.Routes;
import com.app.entity.Travels;

public interface TravelService 
{
	Travels addTravels(Travels travel);
	String deleteTravels(Long travel_id);
	Travels updateeTravels(Travels travel);
	List<Travels> getTravelsList();	
	Set<Routes> getRoutesList(Long travel_id);
	Set<Drivers> getDriversList(Long travel_id);
	
}
