package com.company.animals.herbivores;

import com.company.AnimalStat;
import com.company.animals.Animal;
import com.company.EmptySpace;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

import static com.company.AnimalStat.*;

public class Duck extends Herbivore {

    public Duck(int i, int j) {
        this.locIndexi = i;
        this.locIndexj = j;

        this.name = duckName;
        this.weight = duckWeight;
        this.maxAmountInCell = duckMaxAmountInCell;
        this.maxSpeed = duckMaxSpeed;
        this.foodForSatiety = duckFoodForSatiety;
        this.numberOfMovesAfterHunger = duckNumberOfMovesAfterHunger;
        this.starvationCount = duckStarvationCount;
        this.weightLoss = duckWeightLoss;
        this.chanceToEat = duckChanceToEat;
    }

    @Override
    public Animal reproduce(Animal animal) {
        return new Duck(this.locIndexi, this.locIndexj);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Duck duck = (Duck) o;
        return Double.compare(duck.weight, weight) == 0 && maxAmountInCell == duck.maxAmountInCell && maxSpeed == duck.maxSpeed && Double.compare(duck.foodForSatiety, foodForSatiety) == 0 && numberOfMovesAfterHunger == duck.numberOfMovesAfterHunger && locIndexi == duck.locIndexi && locIndexj == duck.locIndexj && Double.compare(duck.satiety, satiety) == 0 && starvationCount == duck.starvationCount && Double.compare(duck.weightLoss, weightLoss) == 0 && name.equals(duck.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, maxAmountInCell, maxSpeed, foodForSatiety, numberOfMovesAfterHunger, locIndexi, locIndexj, satiety, starvationCount, weightLoss);
    }
}
