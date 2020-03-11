package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * An Interface that will extent the bulit in CrudRepository class.
 * @author Ankur Yadav
 *
 */
public interface VehicleRepository extends CrudRepository<Vehicle, Integer> {

    public List<Vehicle> findByMake(String make);
    public List<Vehicle> findByModel(String model);
    public List<Vehicle> findByVehicleYear(Integer vehicleYear);
}
