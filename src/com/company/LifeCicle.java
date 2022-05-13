package com.company;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class LifeCicle implements Runnable {
    String cells;

    public LifeCicle(String cells) {
        this.cells = cells;
    }

    public void run() {
        synchronized (Location.loc) {
            synchronized (Location.loc.get(cells)) {
                AnimalMovement.movement(cells);
                AnimalEater.eating(cells);
                AnimalReproducer.reproducer(cells);
                GrowPlants.grow(cells);
            }
        }
    }
}