package com.company;

import com.company.Animals.Animal;
import com.company.Animals.Plants;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class GrowPlants {
    public static void grow(String cells) {

            List<Animal> animalList = Location.loc.get(cells);

            for (int l = 0; l < ThreadLocalRandom.current().nextInt(500, 1000); l++) {
                int count2 = (int)animalList.stream().filter(a -> a.getClass() == Plants.class).count();
                if (count2 >= 3000) {
                    break;
                }
                String[] split = cells.split(":");
                int i = Integer.parseInt(split[0]);
                int j = Integer.parseInt(split[1]);
                animalList.add(new Plants(i, j));

            }
    }
}


