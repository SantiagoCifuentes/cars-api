package com.santiago.cars.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "cars")
public class Cars {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(length = 30, nullable = false)
    private String carModel;

    @Column(length = 100)
    private String description;

    @NotNull
    @Column(nullable = false)
    private Integer price;

    @NotNull
    @Column(nullable = false)
    private Integer mileage;


    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brands  brands;


    public Cars(Long id, String carModel, String description, Integer price, Integer mileage) {
        this.id = id;
        this.carModel = carModel;
        this.description = description;
        this.price = price;
        this.mileage = mileage;
    }

    public Cars (){

    }


    public Long getId() {
        return id;
    }

    public String getCarModel() {
        return carModel;
    }



    public String getDescription() {
        return description;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }
}
