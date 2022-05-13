package com.company;

import com.company.Animals.Animal;
import com.company.Animals.Brick;
import com.company.Animals.Plants;

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
                    if (animal.getSatiety() >= animal.getFoodForSatiety()) {
                        break;
                    }
                    animal.eat(animal1, animalList);
                }
            }
    }
}
