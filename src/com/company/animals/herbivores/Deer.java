package com.company.animals.herbivores;

import com.company.AnimalStat;
import com.company.animals.Animal;
import com.company.EmptySpace;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

import static com.company.AnimalStat.*;

public class Deer extends Herbivore {

    public Deer(int i, int j) {
        this.locIndexi = i;
        this.locIndexj = j;

        this.name = deerName;
        this.weight = deerWeight;
        this.maxAmountInCell = deerMaxAmountInCell;
        this.maxSpeed = deerMaxSpeed;
        this.foodForSatiety = deerFoodForSatiety;
        this.numberOfMovesAfterHunger = deerNumberOfMovesAfterHunger;
        this.starvationCount = deerStarvationCount;
        this.weightLoss = deerWeightLoss;
        this.chanceToEat = deerChanceToEat;
    }

    @Override
    public Animal reproduce(Animal animal) {
        return new Deer(this.locIndexi, this.locIndexj);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deer deer = (Deer) o;
        return Double.compare(deer.weight, weight) == 0 && maxAmountInCell == deer.maxAmountInCell && maxSpeed == deer.maxSpeed && Double.compare(deer.foodForSatiety, foodForSatiety) == 0 && numberOfMovesAfterHunger == deer.numberOfMovesAfterHunger && locIndexi == deer.locIndexi && locIndexj == deer.locIndexj && Double.compare(deer.satiety, satiety) == 0 && starvationCount == deer.starvationCount && Double.compare(deer.weightLoss, weightLoss) == 0 && name.equals(deer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, maxAmountInCell, maxSpeed, foodForSatiety, numberOfMovesAfterHunger, locIndexi, locIndexj, satiety, starvationCount, weightLoss);
    }
}
