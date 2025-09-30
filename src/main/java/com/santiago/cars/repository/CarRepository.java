package com.santiago.cars.repository;

import com.santiago.cars.model.Cars;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para gestionar los autos.
 * proporciona métodos CRUD y de paginación
 */

public interface CarRepository extends JpaRepository <Cars, Long> {


}
