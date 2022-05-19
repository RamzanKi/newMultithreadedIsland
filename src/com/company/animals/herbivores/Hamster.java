package com.company.animals.herbivores;

import com.company.AnimalStat;
import com.company.animals.Animal;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

import static com.company.AnimalStat.*;

public class Hamster extends Herbivore {

    public Hamster(int i, int j) {
        this.locIndexi = i;
        this.locIndexj = j;

        this.name = hamsterName;
        this.weight = hamsterWeight;
        this.maxAmountInCell = hamsterMaxAmountInCell;
        this.maxSpeed = hamsterMaxSpeed;
        this.foodForSatiety = hamsterFoodForSatiety;
        this.numberOfMovesAfterHunger = hamsterNumberOfMovesAfterHunger;
        this.starvationCount = hamsterStarvationCount;
        this.weightLoss = hamsterWeightLoss;
        this.chanceToEat = hamsterChanceToEat;
    }

    @Override
    public Animal reproduce(Animal animal) {
        return new Hamster(this.locIndexi, this.locIndexj);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hamster hamster = (Hamster) o;
        return Double.compare(hamster.weight, weight) == 0 && maxAmountInCell == hamster.maxAmountInCell && maxSpeed == hamster.maxSpeed && Double.compare(hamster.foodForSatiety, foodForSatiety) == 0 && numberOfMovesAfterHunger == hamster.numberOfMovesAfterHunger && locIndexi == hamster.locIndexi && locIndexj == hamster.locIndexj && Double.compare(hamster.satiety, satiety) == 0 && starvationCount == hamster.starvationCount && Double.compare(hamster.weightLoss, weightLoss) == 0 && name.equals(hamster.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, maxAmountInCell, maxSpeed, foodForSatiety, numberOfMovesAfterHunger, locIndexi, locIndexj, satiety, starvationCount, weightLoss);
    }
}
