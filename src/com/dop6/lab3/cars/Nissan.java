package com.dop6.lab3.cars;

class Nissan extends Car {

    private CarGEOParams carGEOParams;

    Nissan(GEOType geo) {

        switch (geo) {
            case US:
                carGEOParams = new USCarGEOParams();
                break;
            case EU:
                carGEOParams = new EUCarGEOParams();
                break;
        }
    }

    @Override
    void makeCar() {
        carBrand = "Nissan";
        carShopGEO = carGEOParams.getCarShopGEO();
    }
}
