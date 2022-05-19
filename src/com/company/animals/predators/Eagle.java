package com.company.animals.predators;

import com.company.AnimalStat;
import com.company.animals.Animal;
import com.company.EmptySpace;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

import static com.company.AnimalStat.*;

public class Eagle extends Predator {

    public Eagle(int i, int j) {
        this.locIndexi = i;
        this.locIndexj = j;

        this.name = eagleName;
        this.weight = eagleWeight;
        this.maxAmountInCell = eagleMaxAmountInCell;
        this.maxSpeed = eagleMaxSpeed;
        this.foodForSatiety = eagleFoodForSatiety;
        this.numberOfMovesAfterHunger = eagleNumberOfMovesAfterHunger;
        this.starvationCount = eagleStarvationCount;
        this.weightLoss = eagleWeightLoss;
        this.chanceToEat = eagleChanceToEat;
    }


    @Override
    public Animal reproduce(Animal animal) {
        return new Eagle(this.locIndexi, this.locIndexj);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Eagle eagle = (Eagle) o;
        return Double.compare(eagle.weight, weight) == 0 && maxAmountInCell == eagle.maxAmountInCell && maxSpeed == eagle.maxSpeed && Double.compare(eagle.foodForSatiety, foodForSatiety) == 0 && numberOfMovesAfterHunger == eagle.numberOfMovesAfterHunger && locIndexi == eagle.locIndexi && locIndexj == eagle.locIndexj && Double.compare(eagle.satiety, satiety) == 0 && starvationCount == eagle.starvationCount && Double.compare(eagle.weightLoss, weightLoss) == 0 && name.equals(eagle.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, maxAmountInCell, maxSpeed, foodForSatiety, numberOfMovesAfterHunger, locIndexi, locIndexj, satiety, starvationCount, weightLoss);
    }
}
