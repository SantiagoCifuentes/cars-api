package com.santiago.cars.service;

import com.santiago.cars.model.Cars;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface CarService {

    List<Cars> getAllCars(Pageable pageable);

    Cars getCarById(Long id);

    Cars createCar(Cars cars);
}

