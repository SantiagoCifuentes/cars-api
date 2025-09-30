package com.santiago.cars.service;

import com.santiago.cars.model.Cars;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Servicio para gestionar autos.
 */

public interface CarService {

    List<Cars> getAllCars(Pageable pageable);

    /**
     * Busca un auto por su ID.
     * @param id ID del auto
     * @return el auto encontrado
     * @throws RuntimeException si no se encuentra
     */
    Cars getCarById(Long id);

    Cars createCar(Cars cars);
}

