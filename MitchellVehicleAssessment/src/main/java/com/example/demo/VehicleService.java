package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * A Service class for vehicle repository
 * @author Ankur Yadav
 * All Core logic is written in service class.
 */
@Service
public class VehicleService {

	@Autowired
	VehicleRepository vehicleRepository;
		
	public List<Vehicle> getAllVehicles(){
		List<Vehicle> vehicles = new ArrayList<>();
		vehicleRepository.findAll().forEach(vehicles::add);
		return vehicles;
	}
	
	
	public Vehicle getVehicle(Integer id) {
		return vehicleRepository.findById(id).get();
	}

	
	public void addVehicle(Vehicle vehicle) {
		vehicleRepository.save(vehicle);
		
	}

	
	public void updateVehicle(Integer id, Vehicle vehicle) {
		vehicleRepository.save(vehicle);
	}

	
	public void deleteVehicle(Integer id) {
		vehicleRepository.deleteById(id);
	}


	public List<Vehicle> getVehicle(String param, String value) {
		List<Vehicle> vehicles =  null;
		switch(param) {
			case "make":
				vehicles = vehicleRepository.findByMake(value);
				break;
			case "model":
				vehicles = vehicleRepository.findByModel(value);
				break;
			case "vehicleYear":
				vehicles = vehicleRepository.findByVehicleYear(Integer.parseInt(value));
				break;
		}
		return vehicles;
	}
	

}
