package com.company.animals;

import com.company.EmptySpace;
import com.company.Location;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal {
    public Map<String, Integer> chanceToEat;
    public String name;
    public double weight;
    public int maxAmountInCell;
    public int maxSpeed;
    public double foodForSatiety;
    public int numberOfMovesAfterHunger;
    public int locIndexi;
    public int locIndexj;
    public double satiety;
    public int starvationCount;
    public double weightLoss;


    public void moveDirection() {
        int randomDirection = ThreadLocalRandom.current().nextInt(4);
        if (randomDirection == 0) {
            setIndex(this.locIndexi - ThreadLocalRandom.current().nextInt(this.maxSpeed), this.locIndexj);
            if (this.locIndexi < 0) {
                setIndex(0, this.locIndexj);
            }
        }
        if (randomDirection == 1) {
            setIndex(this.locIndexi, this.locIndexj + ThreadLocalRandom.current().nextInt(this.maxSpeed));
            if (this.locIndexj > Location.island[0].length - 1) {
                setIndex(this.locIndexi, Location.island[0].length - 1);
            }
        }
        if (randomDirection == 2) {
            setIndex(this.locIndexi + ThreadLocalRandom.current().nextInt(this.maxSpeed), this.locIndexj);
            if (this.locIndexi > Location.island.length - 1) {
                setIndex(Location.island.length - 1, this.locIndexj);
            }
        }
        if (randomDirection == 3) {
            setIndex(this.locIndexi, this.locIndexj - ThreadLocalRandom.current().nextInt(this.maxSpeed));
            if (this.locIndexj < 0) {
                setIndex(this.locIndexi, 0);
            }
        }
    }
    public abstract Animal reproduce(Animal animal);

    public double getFoodForSatiety() {
        return foodForSatiety;
    }

    public int getNumberOfMovesAfterHunger() {
        return numberOfMovesAfterHunger;
    }

    public int getStarvationCount() {
        return starvationCount;
    }

    public void setStarvationCount(int starvationCount) {
        this.starvationCount = starvationCount;
    }

    public double getWeightLoss() {
        return weightLoss;
    }

    public void setWeightLoss(double weightLoss) {
        this.weightLoss = weightLoss;
    }

    public double getSatiety() {
        return satiety;
    }

    public void setSatiety(double satiety) {
        this.satiety = satiety;
    }

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
    public double getWeight() {
        return this.weight;
    }

    public void eat(Animal animal, List<Animal> animalList) {
        String simpleName = animal.getClass().getSimpleName();
        int chance = 0;
        for (String s : chanceToEat.keySet()) {
            if (simpleName.equals(s)) {
                chance = chanceToEat.get(s);
                break;
            }
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
    public String toString() {
        return name;
    }
}
