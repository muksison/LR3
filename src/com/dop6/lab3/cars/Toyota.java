package com.dop6.lab3.cars;

class Toyota extends Car {

    private CarGEOParams carGEOParams;

    Toyota(GEOType geo) {

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
        carBrand = "Toyota";
        carShopGEO = carGEOParams.getCarShopGEO();
    }
}
