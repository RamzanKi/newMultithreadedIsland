package com.company.animals.predators;

import com.company.AnimalStat;
import com.company.animals.Animal;
import com.company.EmptySpace;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

import static com.company.AnimalStat.*;

public class Wolf extends Predator {

    public Wolf(int i, int j) {
        this.locIndexi = i;
        this.locIndexj = j;

        this.name = wolfName;
        this.weight = wolfWeight;
        this.maxAmountInCell = wolfMaxAmountInCell;
        this.maxSpeed = wolfMaxSpeed;
        this.foodForSatiety = wolfFoodForSatiety;
        this.numberOfMovesAfterHunger = wolfNumberOfMovesAfterHunger;
        this.starvationCount = wolfStarvationCount;
        this.weightLoss = wolfWeightLoss;
    }

    @Override
    public void eat(Animal animal, List<Animal> animalList) {
        String simpleName = animal.getClass().getSimpleName();
        int chance = 0;
        switch (simpleName) {
            case "Wolf" -> chance = 0;
            case "Snake" -> chance = 0;
            case "Sheep" -> chance = 7;
            case "Rabbit" -> chance = 7;
            case "Kangaroo" -> chance = 2;
            case "Horse" -> chance = 4;
            case "Hamster" -> chance = 9;
            case "Goat" -> chance = 9;
            case "Fox" -> chance = 7;
            case "Eagle" -> chance = 1;
            case "Duck" -> chance = 8;
            case "Deer" -> chance = 4;
            case "Cow" -> chance = 6;
            case "Caterpillar" -> chance = 0;
            case "Bear" -> chance = 3;
            case "Plants" -> chance = 0;
        }
        int random = ThreadLocalRandom.current().nextInt(1, 11);
        if (random >= 1 && random <= chance) {
            String[] split = animal.getIndex().split(":");
            int i = Integer.parseInt(split[0]);
            int j = Integer.parseInt(split[1]);
            animalList.set(animalList.indexOf(animal), new EmptySpace(i, j));
            this.satiety += animal.getWeight();
            if (this.satiety > this.foodForSatiety) {
                this.satiety = foodForSatiety;
            }
        }
    }

    @Override
    public Animal reproduce(Animal animal) {
        return new Wolf(this.locIndexi, this.locIndexj);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wolf wolf = (Wolf) o;
        return Double.compare(wolf.weight, weight) == 0 && maxAmountInCell == wolf.maxAmountInCell && maxSpeed == wolf.maxSpeed && Double.compare(wolf.foodForSatiety, foodForSatiety) == 0 && numberOfMovesAfterHunger == wolf.numberOfMovesAfterHunger && locIndexi == wolf.locIndexi && locIndexj == wolf.locIndexj && Double.compare(wolf.satiety, satiety) == 0 && starvationCount == wolf.starvationCount && Double.compare(wolf.weightLoss, weightLoss) == 0 && name.equals(wolf.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, maxAmountInCell, maxSpeed, foodForSatiety, numberOfMovesAfterHunger, locIndexi, locIndexj, satiety, starvationCount, weightLoss);
    }
}
