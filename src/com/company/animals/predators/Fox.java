package com.company.animals.predators;

import com.company.AnimalStat;
import com.company.animals.Animal;
import com.company.EmptySpace;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

import static com.company.AnimalStat.*;

public class Fox extends Predator {

    public Fox(int i, int j) {
        this.locIndexi = i;
        this.locIndexj = j;

        this.name = foxName;
        this.weight = foxWeight;
        this.maxAmountInCell = foxMaxAmountInCell;
        this.maxSpeed = foxMaxSpeed;
        this.foodForSatiety = foxFoodForSatiety;
        this.numberOfMovesAfterHunger = foxNumberOfMovesAfterHunger;
        this.starvationCount = foxStarvationCount;
        this.weightLoss = foxWeightLoss;
    }

    @Override
    public void eat(Animal animal, List<Animal> animalList) {
        String simpleName = animal.getClass().getSimpleName();
        int chance = 0;
        switch (simpleName){
            case "Wolf" -> chance = 0;
            case "Snake" -> chance = 2;
            case "Sheep" -> chance = 2;
            case "Rabbit" -> chance = 7;
            case "Kangaroo" -> chance = 1;
            case "Horse" -> chance = 0;
            case "Hamster" -> chance = 9;
            case "Goat" -> chance = 2;
            case "Fox" -> chance = 0;
            case "Eagle" -> chance = 1;
            case "Duck" -> chance = 0;
            case "Deer" -> chance = 1;
            case "Cow" -> chance = 0;
            case "Caterpillar" -> chance = 0;
            case "Bear" -> chance = 0;
            case "Plants" -> chance = 0;
        }
        int random = ThreadLocalRandom.current().nextInt(1,11);
        if (random >= 1 && random <= chance) {
            String[] split = animal.getIndex().split(":");
            int i = Integer.parseInt(split[0]);
            int j = Integer.parseInt(split[1]);
            animalList.set(animalList.indexOf(animal), new EmptySpace(i, j));
            this.satiety += animal.getWeight();
            if (this.satiety > this.foodForSatiety) {
                this.satiety = foodForSatiety;
            }
        }
    }

    @Override
    public Animal reproduce(Animal animal) {
        return new Fox(this.locIndexi, this.locIndexj);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fox fox = (Fox) o;
        return Double.compare(fox.weight, weight) == 0 && maxAmountInCell == fox.maxAmountInCell && maxSpeed == fox.maxSpeed && Double.compare(fox.foodForSatiety, foodForSatiety) == 0 && numberOfMovesAfterHunger == fox.numberOfMovesAfterHunger && locIndexi == fox.locIndexi && locIndexj == fox.locIndexj && Double.compare(fox.satiety, satiety) == 0 && starvationCount == fox.starvationCount && Double.compare(fox.weightLoss, weightLoss) == 0 && name.equals(fox.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, maxAmountInCell, maxSpeed, foodForSatiety, numberOfMovesAfterHunger, locIndexi, locIndexj, satiety, starvationCount, weightLoss);
    }
}
