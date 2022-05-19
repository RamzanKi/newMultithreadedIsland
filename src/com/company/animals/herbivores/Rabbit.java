package com.company.animals.herbivores;

import com.company.AnimalStat;
import com.company.animals.Animal;
import com.company.EmptySpace;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

import static com.company.AnimalStat.*;

public class Rabbit extends Herbivore {

    public Rabbit(int i, int j) {
        this.locIndexi = i;
        this.locIndexj = j;

        this.name = rabbitName;
        this.weight = rabbitWeight;
        this.maxAmountInCell = rabbitMaxAmountInCell;
        this.maxSpeed = rabbitMaxSpeed;
        this.foodForSatiety = rabbitFoodForSatiety;
        this.numberOfMovesAfterHunger = rabbitNumberOfMovesAfterHunger;
        this.starvationCount = rabbitStarvationCount;
        this.weightLoss = rabbitWeightLoss;
        this.chanceToEat = rabbitChanceToEat;
    }

    @Override
    public int getMaxAmountInCell() {
        return maxAmountInCell;
    }
    public String getIndex() {
        return this.locIndexi +":"+ this.locIndexj;
    }
    public void setIndex(int i, int j) {
        this.locIndexi = i;
        this.locIndexj = j;
    }

    @Override
    public Animal reproduce(Animal animal) {
        return new Rabbit(this.locIndexi, this.locIndexj);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rabbit rabbit = (Rabbit) o;
        return Double.compare(rabbit.weight, weight) == 0 && maxAmountInCell == rabbit.maxAmountInCell && maxSpeed == rabbit.maxSpeed && Double.compare(rabbit.foodForSatiety, foodForSatiety) == 0 && numberOfMovesAfterHunger == rabbit.numberOfMovesAfterHunger && locIndexi == rabbit.locIndexi && locIndexj == rabbit.locIndexj && Double.compare(rabbit.satiety, satiety) == 0 && starvationCount == rabbit.starvationCount && Double.compare(rabbit.weightLoss, weightLoss) == 0 && name.equals(rabbit.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, maxAmountInCell, maxSpeed, foodForSatiety, numberOfMovesAfterHunger, locIndexi, locIndexj, satiety, starvationCount, weightLoss);
    }
}
