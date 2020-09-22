package ru.otus.homework.model;

import java.util.List;
import java.util.Random;

public enum Classification {
    MTB,
    ROAD_RACING,
    CITY;

    private static final List<Classification> VALUES = List.of(values());
    private static final Random RANDOM = new Random();

    public static Classification randomClassification() {
        return VALUES.get(RANDOM.nextInt(VALUES.size()));
    }
}
