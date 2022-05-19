package com.company.animals.herbivores;

import com.company.AnimalStat;
import com.company.animals.Animal;
import com.company.EmptySpace;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

import static com.company.AnimalStat.*;

public class Goat extends Herbivore {

    public Goat(int i, int j) {
        this.locIndexi = i;
        this.locIndexj = j;

        this.name = goatName;
        this.weight = goatWeight;
        this.maxAmountInCell = goatMaxAmountInCell;
        this.maxSpeed = goatMaxSpeed;
        this.foodForSatiety = goatFoodForSatiety;
        this.numberOfMovesAfterHunger = goatNumberOfMovesAfterHunger;
        this.starvationCount = goatStarvationCount;
        this.weightLoss = goatWeightLoss;
    }

    @Override
    public void eat(Animal animal, List<Animal> animalList) {
        String simpleName = animal.getClass().getSimpleName();
        int chance = 0;
        switch (simpleName){
            case "Wolf" -> chance = 0;
            case "Snake" -> chance = 0;
            case "Sheep" -> chance = 0;
            case "Rabbit" -> chance = 0;
            case "Kangaroo" -> chance = 0;
            case "Horse" -> chance = 0;
            case "Hamster" -> chance = 0;
            case "Goat" -> chance = 0;
            case "Fox" -> chance = 0;
            case "Eagle" -> chance = 0;
            case "Duck" -> chance = 0;
            case "Deer" -> chance = 0;
            case "Cow" -> chance = 0;
            case "Caterpillar" -> chance = 0;
            case "Bear" -> chance = 0;
            case "Plants" -> chance = 10;
        }
        int random = ThreadLocalRandom.current().nextInt(1,11);
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
        return new Goat(this.locIndexi, this.locIndexj);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goat goat = (Goat) o;
        return Double.compare(goat.weight, weight) == 0 && maxAmountInCell == goat.maxAmountInCell && maxSpeed == goat.maxSpeed && Double.compare(goat.foodForSatiety, foodForSatiety) == 0 && numberOfMovesAfterHunger == goat.numberOfMovesAfterHunger && locIndexi == goat.locIndexi && locIndexj == goat.locIndexj && Double.compare(goat.satiety, satiety) == 0 && starvationCount == goat.starvationCount && Double.compare(goat.weightLoss, weightLoss) == 0 && name.equals(goat.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, maxAmountInCell, maxSpeed, foodForSatiety, numberOfMovesAfterHunger, locIndexi, locIndexj, satiety, starvationCount, weightLoss);
    }
}
