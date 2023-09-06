package com.app.service;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Drivers;
import com.app.entity.Travels;
import com.app.repository.DriversRepository;
import com.app.repository.TravelsRepository;

@Service
@Transactional

public class DriverServiceImpl implements DriverService
{
	@Autowired
	private DriversRepository driverRepo;
	@Autowired
	private TravelsRepository travelsRepo;
	

	@Override
	public String deleteDriver(Long driver_id) 
	{
		if(driverRepo.existsById(driver_id))
		{
			driverRepo.deleteById(driver_id);
			return "Delete Successfully";
		}
		return "Delete Unsuccessfully";
	}

	@Override
	public Drivers updateDriver(Drivers driver) 
	{
		return driverRepo.save(driver);
	}

	@Override
	public String addToTravels(Long travels_id,Long driver_id) 
	{
		if(travelsRepo.existsById(travels_id))
		{
			Travels travel=travelsRepo.findById(travels_id).orElseThrow();
			Drivers driver=driverRepo.findById(driver_id).orElseThrow();
			driver.addTravelSet(travel);
			return "Add Successfully";
		}
		return "Not added to travels";
	}

	@Override
	public List<Drivers> getDriverList() 
	{
		return driverRepo.findAll();
	}

	@Override
	public Drivers addDriver(Drivers driver) 
	{
		
		return driverRepo.save(driver);
	}
	
	public Set<Travels> getTravelsList(Long driver_id)
	{
		Set<Travels> list=driverRepo.findById(driver_id).orElseThrow().getTravelSet();
		return list;
	}

	@Override
	public Drivers loginDriver(String email, String password) {
		
		return driverRepo.findByEmailAndPassword(email, password);
	}
	

}
