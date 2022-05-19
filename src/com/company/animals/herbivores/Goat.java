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
        this.chanceToEat = goatChanceToEat;
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
