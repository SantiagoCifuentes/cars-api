package com.santiago.cars.service.impl;


import com.santiago.cars.model.Brands;

import com.santiago.cars.repository.BrandRepository;

import com.santiago.cars.service.BrandsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandsServiceImpl implements BrandsService {


    private final BrandRepository brandsRepository;

    public BrandsServiceImpl(BrandRepository brandRepository) {
        this.brandsRepository = brandRepository;
    }



    @Override
    public List<Brands> getAllBrands() {
        return brandsRepository.findAll();
    }

    @Override
    public Brands createBrand(Brands brands) {
        return brandsRepository.save(brands);
    }


}
