package com.santiago.cars.repository;

import com.santiago.cars.model.Cars;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository <Cars, Long> {


}
