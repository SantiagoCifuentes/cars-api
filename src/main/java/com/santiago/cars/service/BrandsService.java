package com.santiago.cars.service;

import com.santiago.cars.model.Brands;

import java.util.List;

public interface BrandsService {


    List<Brands> getAllBrands();
    Brands createBrand(Brands brands);

}
