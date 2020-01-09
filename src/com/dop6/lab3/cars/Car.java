package com.dop6.lab3.cars;

public abstract class Car {

    String carBrand;
    String carShopGEO;

    abstract void makeCar();

    public String getCarBrand() {
        return carBrand;
    }

    public String getCarShopGEO() {
        return carShopGEO;
    }
}
