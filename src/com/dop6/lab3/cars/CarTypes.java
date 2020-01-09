package com.dop6.lab3.cars;

import java.util.Random;

public enum CarTypes {
    BMW,
    NISSAN,
    TOYOTA;

    public static CarTypes getRandomCarType() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
