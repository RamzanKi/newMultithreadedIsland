package com.company.animals.herbivores;

import com.company.AnimalStat;
import com.company.animals.Animal;
import com.company.EmptySpace;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

import static com.company.AnimalStat.*;

public class Cow extends Herbivore {

    public Cow(int i, int j) {
        this.locIndexi = i;
        this.locIndexj = j;

        this.name = cowName;
        this.weight = cowWeight;
        this.maxAmountInCell = cowMaxAmountInCell;
        this.maxSpeed = cowMaxSpeed;
        this.foodForSatiety = cowFoodForSatiety;
        this.numberOfMovesAfterHunger = cowNumberOfMovesAfterHunger;
        this.starvationCount = cowStarvationCount;
        this.weightLoss = cowWeightLoss;
        this.chanceToEat = cowChanceToEat;
    }

    @Override
    public Animal reproduce(Animal animal) {
        return new Cow(this.locIndexi, this.locIndexj);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cow cow = (Cow) o;
        return Double.compare(cow.weight, weight) == 0 && maxAmountInCell == cow.maxAmountInCell && maxSpeed == cow.maxSpeed && Double.compare(cow.foodForSatiety, foodForSatiety) == 0 && numberOfMovesAfterHunger == cow.numberOfMovesAfterHunger && locIndexi == cow.locIndexi && locIndexj == cow.locIndexj && Double.compare(cow.satiety, satiety) == 0 && starvationCount == cow.starvationCount && Double.compare(cow.weightLoss, weightLoss) == 0 && name.equals(cow.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, maxAmountInCell, maxSpeed, foodForSatiety, numberOfMovesAfterHunger, locIndexi, locIndexj, satiety, starvationCount, weightLoss);
    }
}
