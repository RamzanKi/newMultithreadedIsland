package com.company.animals.herbivores;

import com.company.AnimalStat;
import com.company.animals.Animal;
import com.company.animals.predators.Predator;
import com.company.EmptySpace;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

import static com.company.AnimalStat.*;

public class Bear extends Predator {

    public Bear(int i, int j) {
        this.locIndexi = i;
        this.locIndexj = j;

        this.name = bearName;
        this.weight = bearWeight;
        this.maxAmountInCell = bearMaxAmountInCell;
        this.maxSpeed = bearMaxSpeed;
        this.foodForSatiety = bearFoodForSatiety;
        this.numberOfMovesAfterHunger = bearNumberOfMovesAfterHunger;
        this.starvationCount = bearStarvationCount;
        this.weightLoss = bearWeightLoss;
    }


    @Override
    public void eat(Animal animal, List<Animal> animalList) {
        String simpleName = animal.getClass().getSimpleName();
        int chance = 0;
        switch (simpleName){
            case "Wolf" -> chance = 2;
            case "Snake" -> chance = 0;
            case "Sheep" -> chance = 7;
            case "Rabbit" -> chance = 0;
            case "Kangaroo" -> chance = 6;
            case "Horse" -> chance = 7;
            case "Hamster" -> chance = 9;
            case "Goat" -> chance = 7;
            case "Fox" -> chance = 2;
            case "Eagle" -> chance = 0;
            case "Duck" -> chance = 8;
            case "Deer" -> chance = 8;
            case "Cow" -> chance = 3;
            case "Caterpillar" -> chance = 0;
            case "Bear" -> chance = 0;
            case "Plants" -> chance = 0;
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
        return new Bear(this.locIndexi, this.locIndexj);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bear bear = (Bear) o;
        return Double.compare(bear.weight, weight) == 0 && maxAmountInCell == bear.maxAmountInCell && maxSpeed == bear.maxSpeed && Double.compare(bear.foodForSatiety, foodForSatiety) == 0 && numberOfMovesAfterHunger == bear.numberOfMovesAfterHunger && locIndexi == bear.locIndexi && locIndexj == bear.locIndexj && Double.compare(bear.satiety, satiety) == 0 && starvationCount == bear.starvationCount && Double.compare(bear.weightLoss, weightLoss) == 0 && name.equals(bear.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, maxAmountInCell, maxSpeed, foodForSatiety, numberOfMovesAfterHunger, locIndexi, locIndexj, satiety, starvationCount, weightLoss);
    }
}
