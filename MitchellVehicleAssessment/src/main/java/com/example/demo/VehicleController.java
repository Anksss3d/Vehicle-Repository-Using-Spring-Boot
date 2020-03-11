package com.example.demo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 * A Controller Class for Vehicle Rest Controller
 * @author Ankur Yadav
 *
 */
@RestController
public class VehicleController {

	// Vehicle Service Object
	@Autowired	
	private VehicleService vehicleService;
	
	/**
	 * A method to return data of all vehicle
	 * @return: All Vehicles in JSON Formation
	 */
	@RequestMapping("/vehicles")
	public List<Vehicle> getAllVehicles() {
		return vehicleService.getAllVehicles();
	}
	/**
	 * Return Data of all vehicles whose given parameter value matches passed value
	 * @param param: Filter Parameter
	 * @param value: Filter Value
	 * @return: Vehicles in JSON Form
	 */
	@RequestMapping("/vehicles/{param}/{value}")
	public List<Vehicle> getVehicle(@PathVariable String param, @PathVariable String value) {
		return vehicleService.getVehicle(param, value);
	}
	
	/**
	 * Retrive a vehicle with given Id
	 * @param id: Id of the vehicle
	 * @return: Vehicle in JSON format
	 */
	@RequestMapping("/vehicles/{id}")
	public Vehicle getVehicle(@PathVariable Integer id) {
		return vehicleService.getVehicle(id);
	}
	

	/**
	 * A Method to add a vehicle object into database
	 * @param vehicle: Vehicle object to add
	 * @return: return object if successful, else returns null
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/vehicles")
	public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
		if (vehicle.getVehicleYear() > 2050 || vehicle.getVehicleYear() < 1950) {
			return null;
		}
		vehicleService.addVehicle(vehicle);
		return vehicle;
	}
	
	/**
	 * A method to update the vehicle object of given Id
	 * @param vehicle: update vehicle object
	 * @param id: Id of the vehicle
	 * @return: Object if successful, else returns null
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/vehicles/{id}")
	public Vehicle updateVehicle(@RequestBody Vehicle vehicle, @PathVariable Integer id) {
		if (vehicle.getVehicleYear() > 2050 || vehicle.getVehicleYear() < 1950 || vehicle.getMake().equals("") || vehicle.getModel().equals("")) {
			return null;
		}
		vehicleService.updateVehicle(id, vehicle);
		return vehicle;
	}
	
	/**
	 * A method to delete a vehicle from repository 
	 * @param id: Id of the vehicle
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/vehicles/{id}")
	public void updateVehicle(@PathVariable Integer id) {
		vehicleService.deleteVehicle(id);
	}
	
}
