package com.dop6.lab3.cars;

public class EUCarPlant extends CarPlant {

    @Override
    protected Car createCar(CarTypes type) {

        CarFactory carFactory = new CarFactory();
        return carFactory.createCar(type, GEOType.EU);
    }
}
