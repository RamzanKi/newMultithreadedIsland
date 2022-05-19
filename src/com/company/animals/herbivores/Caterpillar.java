package com.company.animals.herbivores;

import com.company.AnimalStat;
import com.company.animals.Animal;
import com.company.EmptySpace;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

import static com.company.AnimalStat.*;

public class Caterpillar extends Herbivore {

    public Caterpillar(int i, int j) {
        this.locIndexi = i;
        this.locIndexj = j;

        this.name = caterpillarName;
        this.weight = caterpillarWeight;
        this.maxAmountInCell = caterpillarMaxAmountInCell;
        this.maxSpeed = caterpillarMaxSpeed;
        this.foodForSatiety = caterpillarFoodForSatiety;
        this.numberOfMovesAfterHunger = caterpillarNumberOfMovesAfterHunger;
        this.starvationCount = caterpillarStarvationCount;
        this.weightLoss = caterpillarWeightLoss;
        this.chanceToEat = caterpillarChanceToEat;
    }

    @Override
    public Animal reproduce(Animal animal) {
        return new Caterpillar(this.locIndexi, this.locIndexj);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Caterpillar that = (Caterpillar) o;
        return Double.compare(that.weight, weight) == 0 && maxAmountInCell == that.maxAmountInCell && maxSpeed == that.maxSpeed && Double.compare(that.foodForSatiety, foodForSatiety) == 0 && numberOfMovesAfterHunger == that.numberOfMovesAfterHunger && locIndexi == that.locIndexi && locIndexj == that.locIndexj && Double.compare(that.satiety, satiety) == 0 && starvationCount == that.starvationCount && Double.compare(that.weightLoss, weightLoss) == 0 && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, maxAmountInCell, maxSpeed, foodForSatiety, numberOfMovesAfterHunger, locIndexi, locIndexj, satiety, starvationCount, weightLoss);
    }
}
