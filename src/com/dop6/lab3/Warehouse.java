package com.dop6.lab3;

import java.util.concurrent.atomic.AtomicInteger;

class Warehouse {

    private static Warehouse warehouseInstance;

    private AtomicInteger numCars;

    private static final int MAX_CARS = 5;

    private Warehouse() {
        numCars = new AtomicInteger();
        numCars.set(0);
    }

    static Warehouse getWarehouseInstance() {

        if (warehouseInstance == null) {
            warehouseInstance = new Warehouse();
        }

        return warehouseInstance;
    }

    void getWarehouseInfo() {
        System.out.println("Максимальное кол-во автомобилей : " + MAX_CARS);
        System.out.println("Текущее кол-во автомобилей : " + numCars.get());
    }

    void addCar() {
        if (numCars.get() < MAX_CARS) {
            System.out.println("На складе было (автомобилей) : " + numCars.get());
            numCars.getAndIncrement();
            System.out.println("На складе стало (автомобилей) : " + numCars.get());
        } else {
            System.out.println("На складе недостаточно места");
        }
    }

    void removeCar() {
        if (numCars.get() > 0) {
            System.out.println("На складе было (автомобилей) : " + numCars.get());
            numCars.getAndDecrement();
            System.out.println("На складе стало (автомобилей) : " + numCars.get());
        } else {
            System.out.println("На складе закончились автомобили");
        }
    }
}
