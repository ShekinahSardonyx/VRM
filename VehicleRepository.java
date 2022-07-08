package com.vrm.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.vrm.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer>{

	
}
