package com.santiago.cars.repository;

import com.santiago.cars.model.Brands;

import org.springframework.data.jpa.repository.JpaRepository;

/**
    * Repositorio para gestionar las marcas de autos.
 */

public interface BrandRepository extends JpaRepository<Brands, Long> {
}
