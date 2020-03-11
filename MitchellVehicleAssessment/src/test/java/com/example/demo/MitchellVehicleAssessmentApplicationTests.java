package com.example.demo;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MitchellVehicleAssessmentApplicationTests {

	
	@Mock
    private VehicleService vehicleService;
	
    @InjectMocks
    VehicleController vehicleController;


    @Test
    public void testFindAll() 
    {
        Vehicle vehicle1 = new Vehicle(1, "Hundai", "Elantra", 2013);
        Vehicle vehicle2 = new Vehicle(2, "Porche", "Carrera GT", 2005);
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(vehicle1);
        vehicles.add(vehicle2);
 
        when(vehicleService.getAllVehicles()).thenReturn(vehicles);
 
        // when
        List<Vehicle> result = vehicleController.getAllVehicles();
 
        // then
        assertThat(result.size()).isEqualTo(2);
         
        assertThat(result.get(0).getMake())
                        .isEqualTo(vehicle1.getMake());
         
        assertThat(result.get(1).getMake())
                        .isEqualTo(vehicle2.getMake());
    }
    
    @Test
    public void testGet() {
    	Vehicle vehicle1 = new Vehicle(1, "Hundai", "Elantra", 2013);
        Vehicle vehicle2 = new Vehicle(2, "Porche", "Carrera GT", 2005);
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(vehicle1);
        vehicles.add(vehicle2);
        when(vehicleService.getVehicle(2)).thenReturn(vehicles.get(1));
        Vehicle result = vehicleController.getVehicle(2);
        assertThat(result.getId()).isEqualTo(vehicle2.getId());
        assertThat(result.getModel()).isEqualTo(vehicle2.getModel());
    }
    
    @Test
    public void testGetByParam() {
    	Vehicle vehicle1 = new Vehicle(1, "Hundai", "Elantra", 2013);
        Vehicle vehicle2 = new Vehicle(2, "Hundai", "Carrera GT", 2005);
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(vehicle1);
        vehicles.add(vehicle2);
        
        when(vehicleService.getVehicle("make", "Hundai")).thenReturn(vehicles);
        
        List<Vehicle> result = vehicleController.getVehicle("make", "Hundai");
        assertThat(result.get(0).getId()).isEqualTo(vehicle1.getId());
        assertThat(result.get(1).getModel()).isEqualTo(vehicle2.getModel());
        assertThat(result.get(1).getVehicleYear()).isEqualTo(vehicle2.getVehicleYear());
    }
    

}
