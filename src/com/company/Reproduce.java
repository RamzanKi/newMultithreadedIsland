package com.company;

public class Reproduce implements Runnable {

    public void run() {
        synchronized (Location.loc) {
            for (String cells : Location.loc.keySet()) {
                synchronized (Location.loc.get(cells)) {
                    AnimalReproducer.reproducer(cells);
                }
            }
        }
    }
}

