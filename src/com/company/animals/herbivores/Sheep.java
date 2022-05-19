package com.company.animals.herbivores;

import com.company.AnimalStat;
import com.company.animals.Animal;
import com.company.EmptySpace;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

import static com.company.AnimalStat.*;

public class Sheep extends Herbivore {

    public Sheep(int i, int j) {
        this.locIndexi = i;
        this.locIndexj = j;

        this.name = sheepName;
        this.weight = sheepWeight;
        this.maxAmountInCell = sheepMaxAmountInCell;
        this.maxSpeed = sheepMaxSpeed;
        this.foodForSatiety = sheepFoodForSatiety;
        this.numberOfMovesAfterHunger = sheepNumberOfMovesAfterHunger;
        this.starvationCount = sheepStarvationCount;
        this.weightLoss = sheepWeightLoss;
        this.chanceToEat = sheepChanceToEat;
    }

    @Override
    public Animal reproduce(Animal animal) {
        return new Sheep(this.locIndexi, this.locIndexj);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sheep sheep = (Sheep) o;
        return Double.compare(sheep.weight, weight) == 0 && maxAmountInCell == sheep.maxAmountInCell && maxSpeed == sheep.maxSpeed && Double.compare(sheep.foodForSatiety, foodForSatiety) == 0 && numberOfMovesAfterHunger == sheep.numberOfMovesAfterHunger && locIndexi == sheep.locIndexi && locIndexj == sheep.locIndexj && Double.compare(sheep.satiety, satiety) == 0 && starvationCount == sheep.starvationCount && Double.compare(sheep.weightLoss, weightLoss) == 0 && name.equals(sheep.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, maxAmountInCell, maxSpeed, foodForSatiety, numberOfMovesAfterHunger, locIndexi, locIndexj, satiety, starvationCount, weightLoss);
    }
}
