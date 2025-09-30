package com.santiago.cars.repository;

import com.santiago.cars.model.Cars;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICarRepository  extends JpaRepository <Cars, Long> {


}
