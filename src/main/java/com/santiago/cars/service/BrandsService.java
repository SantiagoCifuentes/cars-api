package com.santiago.cars.service;

import com.santiago.cars.model.Brands;

import java.util.List;

public interface BrandsService {

    /**
     * Obtiene la lista de todas las marcas.
     * @return lista de marcas
     */
    List<Brands> getAllBrands();


    /**
     * Crea una nueva marca.
     * @param brands datos de la marca a crear
     * @return la marca creada
     */
    Brands createBrand(Brands brands);

}
