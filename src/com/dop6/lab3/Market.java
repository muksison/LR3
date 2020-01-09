package com.dop6.lab3;

import com.dop6.lab3.cars.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Market {

    private static final String TITLE = "======== 8T6B Petrov D. O. ========";
    private static final String LINES = "===================================";

    public static void main(String[] args) {

        System.out.println(TITLE);

        Warehouse.getWarehouseInstance().getWarehouseInfo();

        System.out.println(LINES);

        Runnable taskCreateCars = () -> {

            // Добавляю на склад сразу 2 авто, для демонстрации ситуации, при которой выпуск быстрее потребления
            for (int i = 1; i < 2; i++) {

                List<CarPlant> carsPlantsList = Arrays.asList(new EUCarPlant(), new USCarPlant());
                CarPlant randomCarPlant = carsPlantsList.get((new Random()).nextInt(carsPlantsList.size()));

                Car car = randomCarPlant.orderCar(CarTypes.getRandomCarType());
                showCarInfo(car);

                Warehouse.getWarehouseInstance().addCar();

                System.out.println(LINES);
            }
        };

        Runnable taskBuyCars = () -> {

            Warehouse.getWarehouseInstance().removeCar();
            System.out.println(LINES);
        };

        List<Thread> threadList = Arrays.asList(new Thread(taskCreateCars), new Thread(taskBuyCars));

        ExecutorService executor= Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        try{
            while(true) {
                executor.execute(threadList.get((new Random()).nextInt(threadList.size())));
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }catch(Exception err){
            err.printStackTrace();
        }
        executor.shutdown();
    }

    private static void showCarInfo(Car car) {
        System.out.println("Бренд : " + car.getCarBrand());
        System.out.println("ГЕО : " + car.getCarShopGEO());
    }
}
