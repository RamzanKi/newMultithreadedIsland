package com.company;

import com.company.Animals.Animal;
import com.company.Animals.Brick;
import com.company.Animals.Herbivore;
import com.company.Animals.Plants;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class AnimalReproducer {
    public static int newBorn = 0;

    public static void reproducer(String cells) {
        for (List<Animal> animalList : Location.loc.values()) {
            animalList.removeIf(a -> a.getClass() == EmptySpace.class);
        }
            List<Animal> animalList = Location.loc.get(cells);

            List<Animal> reproduced = new CopyOnWriteArrayList<>();

            for (Animal animal : animalList) {
                if (animal.getClass() == EmptySpace.class || animal.getClass() == Plants.class || animal.getClass() == Brick.class) {
                    continue;
                }

                for (Animal animal1 : animalList) {
                    if (animalList.stream().noneMatch(a -> a.getClass().getSuperclass() == Herbivore.class)) {
                        break;
                    }
                    if (animal.equals(animal1)) {
                        continue;
                    }
                    if (animal.getClass() == animal1.getClass()) {
                        int r = ThreadLocalRandom.current().nextInt(4);
                        if (r == 1 || animal.getSatiety() == animal.getFoodForSatiety()) {
                            Animal reproduce = animal.reproduce(animal1);
                            int countNewborn = (int) reproduced.stream().filter(a -> a.getClass() == animal.getClass()).count();
                            int count = (int) animalList.stream().filter(a -> a.getClass() == animal.getClass()).count();
                            if (count + countNewborn >= animal.getMaxAmountInCell()) {
                                break;
                            }
                            reproduced.add(reproduce);
                            break;
                        } else {
                            break;
                        }
                    }
                }
            }
            newBorn += reproduced.size();
            animalList.addAll(reproduced);
    }
}
