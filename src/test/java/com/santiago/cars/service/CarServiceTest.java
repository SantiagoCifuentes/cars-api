package com.santiago.cars.service;


import com.santiago.cars.model.Cars;
import com.santiago.cars.repository.CarRepository;
import com.santiago.cars.service.impl.CarServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CarServiceTest {


    private final CarRepository carRepository = mock(CarRepository.class);
    private final CarService carService = new CarServiceImpl(carRepository);


    @Test
    void testFindByIdExists() {
        Cars car = new Cars(1L, "Corolla", "Auto compacto", 20000, 50000);
        when(carRepository.findById(1L)).thenReturn(Optional.of(car));

        Cars result = carService.getCarById(1L);

        assertNotNull(result);
        assertEquals("Corolla", result.getCarModel());
    }

    @Test
    void testFindByIdNotExists() {
        when(carRepository.findById(1L)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            carService.getCarById(1L);
        });

        assertEquals("No se encuentra el carro", exception.getMessage());
    }
}
