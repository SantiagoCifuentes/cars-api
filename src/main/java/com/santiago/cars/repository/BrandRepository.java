package com.santiago.cars.repository;

import com.santiago.cars.model.Brands;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brands, Long> {
}
