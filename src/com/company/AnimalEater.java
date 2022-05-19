package com.company;

import com.company.animals.Animal;
import com.company.animals.Brick;
import com.company.animals.Plants;

import java.util.List;

public class AnimalEater {
    public static void eating(String cells) {
        for (List<Animal> animalList : Location.loc.values()) {
            animalList.removeIf(a -> a.getClass() == EmptySpace.class);
        }
            List<Animal> animalList = Location.loc.get(cells);
            for (Animal animal : animalList) {
                if (animal.getClass() == EmptySpace.class || animal.getClass() == Plants.class || animal.getClass() == Brick.class) {
                    continue;
                }
                for (Animal animal1 : animalList) {
                    if (animal1.getClass() == EmptySpace.class || animal1.getClass() == Plants.class || animal1.getClass() == Brick.class) {
                        continue;
                    }
                    if (animal.getSatiety() >= animal.getFoodForSatiety()) {
                        break;
                    }
                    animal.eat(animal1, animalList);
                }
            }
    }
}
