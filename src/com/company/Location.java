package com.company;

import com.company.animals.*;
import com.company.animals.herbivores.*;
import com.company.animals.predators.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;


public class Location {
    public static final Animal[][] island = new Animal[10][10];
    public static final List<Animal> location = new CopyOnWriteArrayList<>();
    public static Map<String, List<Animal>> loc = new ConcurrentHashMap<>();

    public static void fillLocation() {
        for (int i = 0; i < Location.island.length; i++) {
            for (int j = 0; j < Location.island[i].length; j++) {

                for (int l = 0; l < ThreadLocalRandom.current().nextInt(30); l++) {
                    Location.location.add(new Wolf(i, j));
                }
                for (int l = 0; l < ThreadLocalRandom.current().nextInt(123); l++) {
                    Location.location.add(new Snake(i, j));
                }
                for (int l = 0; l < ThreadLocalRandom.current().nextInt(156); l++) {
                    Location.location.add(new Sheep(i, j));
                }
                for (int l = 0; l < ThreadLocalRandom.current().nextInt(750); l++) {
                    Location.location.add(new Rabbit(i, j));
                }
                for (int l = 0; l < ThreadLocalRandom.current().nextInt(10000); l++) {
                    Location.location.add(new Plants(i, j));
                }
                for (int l = 0; l < ThreadLocalRandom.current().nextInt(149); l++) {
                    Location.location.add(new Kangaroo(i, j));
                }
                for (int l = 0; l < ThreadLocalRandom.current().nextInt(23); l++) {
                    Location.location.add(new Horse(i, j));
                }
                for (int l = 0; l < ThreadLocalRandom.current().nextInt(10000); l++) {
                    Location.location.add(new Hamster(i, j));
                }
                for (int l = 0; l < ThreadLocalRandom.current().nextInt(107); l++) {
                    Location.location.add(new Goat(i, j));
                }
                for (int l = 0; l < ThreadLocalRandom.current().nextInt(50); l++) {
                    Location.location.add(new Fox(i, j));
                }
                for (int l = 0; l < ThreadLocalRandom.current().nextInt(166); l++) {
                    Location.location.add(new Eagle(i, j));
                }
                for (int l = 0; l < ThreadLocalRandom.current().nextInt(500); l++) {
                    Location.location.add(new Duck(i, j));
                }
                for (int l = 0; l < ThreadLocalRandom.current().nextInt(41); l++) {
                    Location.location.add(new Deer(i, j));
                }
                for (int l = 0; l < ThreadLocalRandom.current().nextInt(20); l++) {
                    Location.location.add(new Cow(i, j));
                }
                for (int l = 0; l < ThreadLocalRandom.current().nextInt(10000); l++) {
                    Location.location.add(new Caterpillar(i, j));
                }
                for (int l = 0; l < ThreadLocalRandom.current().nextInt(7); l++) {
                    Location.location.add(new Bear(i, j));
                }
            }
        }
        Location.loc = location.stream().collect(Collectors.groupingByConcurrent(Animal::getIndex));

        for (List<Animal> value : Location.loc.values()) {
            value.add(new Brick());
        }
    }
}