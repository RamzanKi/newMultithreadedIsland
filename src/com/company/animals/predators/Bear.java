package com.company.animals.predators;

import com.company.animals.Animal;
import com.company.EmptySpace;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
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
        this.chanceToEat = bearChanceToEat;
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
