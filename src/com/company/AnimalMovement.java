package com.company;

import com.company.Animals.Animal;
import com.company.Animals.Brick;
import com.company.Animals.Plants;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class AnimalMovement {
    public static int deathCount;

    public static void movement(String cells) {
        for (List<Animal> animalList : Location.loc.values()) {
            animalList.removeIf(a -> a.getClass() == EmptySpace.class);
        }
            List<Animal> animalList = Location.loc.get(cells);
            List<Animal> animals = new CopyOnWriteArrayList<>(animalList);

            for (Animal animal : animalList) {
                if (animal.getClass() == EmptySpace.class || animal.getClass() == Plants.class || animal.getClass() == Brick.class) {
                    continue;
                }
                if (starvation(animal, animalList)) {
                    deathCount++;
                    continue;
                }
                int indexInArray = animalList.indexOf(animal);
                String oldIndex = animal.getIndex();
                animal.moveDirection();
                String newIndex = animal.getIndex();
                if (newIndex.equals(cells)) {
                    continue;
                }
                String[] split = oldIndex.split(":");
                int i = Integer.parseInt(split[0]);
                int j = Integer.parseInt(split[1]);
                animalList.set(indexInArray, new EmptySpace(i, j));

                List<Animal> animalList1 = Location.loc.get(newIndex);
                if (animalList1 == null) {
                    continue;
                }
                if (!checkAmountInCell(animalList1, animal)) {
                    animal.setIndex(i, j);
                    animalList.set(indexInArray, animal);
                    continue;
                }
                if (containsInstance(animalList1, EmptySpace.class)) {
                    Animal animal2 = animalList1.stream().filter(a -> a.getClass() == EmptySpace.class).findFirst().get();
                    int i1 = animalList1.indexOf(animal2);
                    if (i1 != -1) {
                        animalList1.set(i1, animal);
                    }
                } else {
                    animalList1.add(animal);
                }
            }
    }

    public static <E> boolean containsInstance(List<E> list, Class<? extends E> clazz) {
        return list.stream().anyMatch(clazz::isInstance);
    }

    public static boolean checkAmountInCell(List<Animal> animalList, Animal animal) {
        int count = (int) animalList.stream().filter(a -> a.getClass() == animal.getClass()).count();
        if (count >= animal.getMaxAmountInCell()) {
            return false;
        }
        return true;
    }

    public static boolean starvation(Animal animal, List<Animal> animalList) {
        boolean flag = false;
        double satiety = animal.getSatiety();
        double v = satiety - animal.getWeightLoss();
        animal.setSatiety(v);
        if (v < 0) {
            animal.setSatiety(0);
        }
        if (animal.getSatiety() == 0) {
            int starvationCount = (int) (animal.getStarvationCount() - animal.getWeightLoss());
            animal.setStarvationCount(starvationCount);
            if (starvationCount < 0) {
                animal.setStarvationCount(0);
            }
            if (starvationCount <= 0) {
                int i = animalList.indexOf(animal);
                animalList.set(i, new EmptySpace());

                flag = true;
            }
        }
        return flag;
    }
}
