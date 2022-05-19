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
        this.chanceToEat = wolfChanceToEat;
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
