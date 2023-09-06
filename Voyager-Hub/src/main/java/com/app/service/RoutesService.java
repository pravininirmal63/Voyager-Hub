package com.app.service;

import java.util.List;
import java.util.Set;

import com.app.entity.Customer;
import com.app.entity.Routes;
import com.app.entity.Travels;

public interface RoutesService 
{
	Routes addRoute(Routes route);
	String deleteRoute(Long cust_id);
	Routes updateRoute(Routes route);
	String addToTravels(Long cust_id,Long travels_id);
	List<Routes> getRoutesList();	
	List<Customer> getCustomerList(Long route_id);	
	Set<Travels> getTravelsList(Long route_id);
}
