package com.company.animals.herbivores;

import com.company.AnimalStat;
import com.company.animals.Animal;
import com.company.EmptySpace;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

import static com.company.AnimalStat.*;

public class Horse extends Herbivore {

    public Horse(int i, int j) {
        this.locIndexi = i;
        this.locIndexj = j;

        this.name = horseName;
        this.weight = horseWeight;
        this.maxAmountInCell = horseMaxAmountInCell;
        this.maxSpeed = horseMaxSpeed;
        this.foodForSatiety = horseFoodForSatiety;
        this.numberOfMovesAfterHunger = horseNumberOfMovesAfterHunger;
        this.starvationCount = horseStarvationCount;
        this.weightLoss = horseWeightLoss;
        this.chanceToEat = horseChanceToEat;
    }

    @Override
    public Animal reproduce(Animal animal) {
        return new Horse(this.locIndexi, this.locIndexj);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horse horse = (Horse) o;
        return Double.compare(horse.weight, weight) == 0 && maxAmountInCell == horse.maxAmountInCell && maxSpeed == horse.maxSpeed && Double.compare(horse.foodForSatiety, foodForSatiety) == 0 && numberOfMovesAfterHunger == horse.numberOfMovesAfterHunger && locIndexi == horse.locIndexi && locIndexj == horse.locIndexj && Double.compare(horse.satiety, satiety) == 0 && starvationCount == horse.starvationCount && Double.compare(horse.weightLoss, weightLoss) == 0 && name.equals(horse.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, maxAmountInCell, maxSpeed, foodForSatiety, numberOfMovesAfterHunger, locIndexi, locIndexj, satiety, starvationCount, weightLoss);
    }
}
