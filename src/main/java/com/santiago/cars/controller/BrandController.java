package com.santiago.cars.controller;

import com.santiago.cars.model.Brands;
import com.santiago.cars.service.BrandsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/brands")
public class BrandController {

    private final BrandsService brandService;

    public BrandController(BrandsService brandService) {
        this.brandService = brandService;
    }

    @GetMapping
    public ResponseEntity<?> getAllBrands() {
        return ResponseEntity.ok(Map.of(
                "data", brandService.getAllBrands(),
                "status", 200,
                "message", "Respuesta ok"
        ));
    }

    @PostMapping
    public ResponseEntity<?> createBrand(@RequestBody Brands brand) {
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                "data", brandService.createBrand(brand),
                "status", 201,
                "message", "Marca creada correctamente"
        ));
    }
}