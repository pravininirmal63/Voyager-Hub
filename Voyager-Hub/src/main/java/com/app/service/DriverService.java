package com.app.service;

import java.util.List;

import com.app.entity.Customer;
import com.app.entity.Drivers;

public interface DriverService 
{
	Drivers addDriver(Drivers customer);
	String deleteDriver(Long cust_id);
	Drivers updateDriver(Drivers customer);
	String addToTravels(Long cust_id,Long driver_id);
	List<Drivers> getDriverList();
	Drivers loginDriver(String email,String password);

}
