package com.dop6.lab3.cars;

class CarFactory {

    Car createCar(CarTypes type, GEOType geo) {

        Car car = null;

        switch (type) {
            case BMW:
                car = new BMW(geo);
                break;
            case NISSAN:
                car = new Nissan(geo);
                break;
            case TOYOTA:
                car = new Toyota(geo);
                break;
        }

        return car;
    }
}
