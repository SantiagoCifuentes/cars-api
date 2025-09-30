package com.santiago.cars.service.impl;

import com.santiago.cars.model.Cars;
import com.santiago.cars.repository.CarRepository;
import com.santiago.cars.service.CarService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Cars> getAllCars(Pageable pageable) {
        return carRepository.findAll(pageable).getContent();
    }

    @Override
    public Cars getCarById(Long id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encuentra el carro"));
    }

    @Override
    public Cars createCar(Cars car) {
        return carRepository.save(car);
    }
}