package com.app.service;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Customer;
import com.app.entity.Routes;
import com.app.entity.Travels;
import com.app.repository.RoutesRepository;
import com.app.repository.TravelsRepository;

@Service
@Transactional

public class RoutesServiceImpl implements RoutesService
{
	@Autowired
	private RoutesRepository routesRepo;
	@Autowired
	private TravelsRepository travelsRepo;

	@Override
	public Routes addRoute(Routes route) {

		return routesRepo.save(route);
	}

	@Override
	public String deleteRoute(Long cust_id) {
		if(routesRepo.existsById(cust_id))
		{
			routesRepo.delete(routesRepo.findById(cust_id).orElseThrow());
			return "Deleted Succefully";
		}
		return "Not deleted routes";
	}

	@Override
	public Routes updateRoute(Routes route) 
	{
		return routesRepo.save(route);
	}

	@Override
	public String addToTravels(Long route_id,Long travels_id) 
	{
		
		if(routesRepo.existsById(route_id))
		{
			Routes route=routesRepo.findById(route_id).orElseThrow();
			Travels travels=travelsRepo.findById(travels_id).orElseThrow();
			route.addTravels(travels);
			return "Added successfully";
		}
		return "Not added to travels";
	}

	@Override
	public List<Routes> getRoutesList(){
		
		return routesRepo.findAll();
	}
	
	@Override
	public Set<Travels> getTravelsList(Long route_id)
	{
		
		if(routesRepo.existsById(route_id))
		{
			Routes route=routesRepo.findById(route_id).orElseThrow();
			
			
			return route.getTravels();
		}
		return null;
	}

	@Override
	public List<Customer> getCustomerList(Long route_id) 
	{
		if(routesRepo.existsById(route_id))
		{
			Routes route=routesRepo.findById(route_id).orElseThrow();
			
			
			return route.getCustomerList();
		}
		
		return null;
	}

}
