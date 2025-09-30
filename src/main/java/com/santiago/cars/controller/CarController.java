package com.santiago.cars.controller;

import com.santiago.cars.model.Cars;
import com.santiago.cars.service.CarService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Controlador REST para gestionar autos.
 */
@RestController
@RequestMapping("/api/cars")
public class CarController {
    /**
     * Servicio para operaciones de autos.
     */

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    /**
     * Obtiene la lista paginada de autos.
     * @param pageable información de paginación
     * @return lista de autos
     */
    @GetMapping
    public ResponseEntity<?> getAllCars(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        List<Cars> cars = carService.getAllCars(pageable);

        return ResponseEntity.ok(Map.of(
                "data", cars,
                "status", 200,
                "message", "Respuesta ok"
        ));
    }


    /**
     * Obtiene los autos por su ID.
     * @param id ID del auto
     * @return el auto encontrado
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getCarById(@PathVariable Long id) {
        Cars car = carService.getCarById(id);

        return ResponseEntity.ok(Map.of(
                "data", car,
                "status", 200,
                "message", "Respuesta ok"
        ));
    }

    /**
     * Crea un nuevo auto.
     * @param car datos del auto a crear
     * @return el auto creado
     */

    @PostMapping
    public ResponseEntity<?> createCar(@RequestBody Cars car) {
        Cars savedCar = carService.createCar(car);

        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                "data", savedCar,
                "status", 201,
                "message", "Automóvil creado correctamente"
        ));
    }
}