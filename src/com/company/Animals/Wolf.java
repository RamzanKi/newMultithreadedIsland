package com.company.Animals;

import com.company.EmptySpace;
import com.company.Location;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class Wolf extends Predator {
    private final String name = "\uD83D\uDC3A";
    private final double weight = 50.0;
    private final int maxAmountInCell = 30;
    private final int maxSpeed = 3 + 1;
    private final double foodForSatiety = 8;
    private final int numberOfMovesAfterHunger = 10;
    private int locIndexi;
    private int locIndexj;
    private double satiety;
    private int starvationCount = 10;
    private double weightLoss = 1;

    public Wolf(int i, int j) {
        this.locIndexi = i;
        this.locIndexj = j;
    }

    @Override
    public void eat(Animal animal, List<Animal> animalList) {
        String simpleName = animal.getClass().getSimpleName();
        int chance = 0;
        switch (simpleName){
            case "Wolf" -> chance = 0;
            case "Snake" -> chance = 0;
            case "Sheep" -> chance = 7;
            case "Rabbit" -> chance = 7;
            case "Kangaroo" -> chance = 2;
            case "Horse" -> chance = 4;
            case "Hamster" -> chance = 9;
            case "Goat" -> chance = 9;
            case "Fox" -> chance = 7;
            case "Eagle" -> chance = 1;
            case "Duck" -> chance = 8;
            case "Deer" -> chance = 4;
            case "Cow" -> chance = 6;
            case "Caterpillar" -> chance = 0;
            case "Bear" -> chance = 3;
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

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public Animal reproduce(Animal animal) {
        Wolf wolf = new Wolf(this.locIndexi, this.locIndexj);
        wolf.setSatiety(0);
        return wolf;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wolf wolf = (Wolf) o;
        return Double.compare(wolf.weight, weight) == 0 && maxAmountInCell == wolf.maxAmountInCell && maxSpeed == wolf.maxSpeed && Double.compare(wolf.foodForSatiety, foodForSatiety) == 0 && numberOfMovesAfterHunger == wolf.numberOfMovesAfterHunger && locIndexi == wolf.locIndexi && locIndexj == wolf.locIndexj && Double.compare(wolf.satiety, satiety) == 0 && starvationCount == wolf.starvationCount && Double.compare(wolf.weightLoss, weightLoss) == 0 && name.equals(wolf.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, maxAmountInCell, maxSpeed, foodForSatiety, numberOfMovesAfterHunger, locIndexi, locIndexj, satiety, starvationCount, weightLoss);
    }
}
