package com.dop6.lab3.cars;

class BMW extends Car {

    private CarGEOParams carGEOParams;

     BMW(GEOType geo) {

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
        carBrand = "BMW";
        carShopGEO = carGEOParams.getCarShopGEO();
    }
}
