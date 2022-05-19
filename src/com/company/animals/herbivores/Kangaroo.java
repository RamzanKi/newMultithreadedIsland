package com.company.animals.herbivores;

import com.company.AnimalStat;
import com.company.animals.Animal;
import com.company.EmptySpace;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

import static com.company.AnimalStat.*;

public class Kangaroo extends Herbivore {

    public Kangaroo(int i, int j) {
        this.locIndexi = i;
        this.locIndexj = j;

        this.name = kangarooName;
        this.weight = kangarooWeight;
        this.maxAmountInCell = kangarooMaxAmountInCell;
        this.maxSpeed = kangarooMaxSpeed;
        this.foodForSatiety = kangarooFoodForSatiety;
        this.numberOfMovesAfterHunger = kangarooNumberOfMovesAfterHunger;
        this.starvationCount = kangarooStarvationCount;
        this.weightLoss = kangarooWeightLoss;
        this.chanceToEat = kangarooChanceToEat;
    }

    @Override
    public Animal reproduce(Animal animal) {
        return new Kangaroo(this.locIndexi, this.locIndexj);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kangaroo kangaroo = (Kangaroo) o;
        return Double.compare(kangaroo.weight, weight) == 0 && maxAmountInCell == kangaroo.maxAmountInCell && maxSpeed == kangaroo.maxSpeed && Double.compare(kangaroo.foodForSatiety, foodForSatiety) == 0 && numberOfMovesAfterHunger == kangaroo.numberOfMovesAfterHunger && locIndexi == kangaroo.locIndexi && locIndexj == kangaroo.locIndexj && Double.compare(kangaroo.satiety, satiety) == 0 && starvationCount == kangaroo.starvationCount && Double.compare(kangaroo.weightLoss, weightLoss) == 0 && name.equals(kangaroo.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, maxAmountInCell, maxSpeed, foodForSatiety, numberOfMovesAfterHunger, locIndexi, locIndexj, satiety, starvationCount, weightLoss);
    }
}
