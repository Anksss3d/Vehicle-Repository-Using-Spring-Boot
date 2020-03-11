package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * A Vehicle class that is used as an entity in the database
 * @author Ankur Yadav
 *
 */
@Entity
public class Vehicle {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String make;
	private String model;
	private Integer vehicleYear;
	
	/**
	 * Empty Constructor
	 */
	public Vehicle() {
	}
	
	/**
	 * Parameterised Constructor
	 * @param id: Id of the vehicle
	 * @param make: Make of the vehicle
	 * @param model: Model of the vehicle
	 * @param vehicleYear: Year of the vehicle
	 */
	public Vehicle(Integer id, String make, String model, Integer vehicleYear) {
		super();
		this.id = id;
		this.make = make;
		this.model = model;
		this.vehicleYear = vehicleYear;
	}

	/**
	 * Getter for Id
	 * @return: Id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Setter for Id
	 * @param id: new Id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Getter for Make
	 * @return: make
	 */
	public String getMake() {
		return make;
	}

	/**
	 * Setter for make
	 * @param make: new make
	 */
	public void setMake(String make) {
		this.make = make;
	}

	/**
	 * Getter for Model
	 * @return: model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * Setter for model
	 * @param model: new model
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * Getter for the year
	 * @return: year
	 */
	public Integer getVehicleYear() {
		return vehicleYear;
	}

	/**
	 * Setter for the year
	 * @param vehicleYear: new year
	 */
	public void setVehicleYear(Integer vehicleYear) {
		this.vehicleYear = vehicleYear;
	}

	/**
	 * Method to convert the object to the string.
	 */
	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", make=" + make + ", model=" + model + ", vehicleYear=" + vehicleYear + "]";
	}
	
	


	
}
