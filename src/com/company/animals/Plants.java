package com.company.animals;

import java.util.List;
import java.util.Objects;

public class Plants extends Animal{
    private final String name = "\uD83C\uDF3F";
    private final double weight = 5;
    private final int maxAmountInCell = 10000;
    private int locIndexi;
    private int locIndexj;


    public Plants(int i, int j) {
        this.locIndexi = i;
        this.locIndexj = j;
    }

    @Override
    public int getMaxAmountInCell() {
        return this.maxAmountInCell;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public double getSatiety() {
        return 0;
    }

    @Override
    public void setSatiety(double satiety) {

    }

    @Override
    public double getFoodForSatiety() {
        return 0;
    }

    @Override
    public int getNumberOfMovesAfterHunger() {
        return 0;
    }

    @Override
    public int getStarvationCount() {
        return 0;
    }

    @Override
    public void setStarvationCount(int starvationCount) {

    }

    @Override
    public double getWeightLoss() {
        return 0;
    }

    @Override
    public void setWeightLoss(double weightLoss) {

    }

    public String getIndex() {
        return this.locIndexi +":"+ this.locIndexj;
    }

    @Override
    public void eat(Animal animal, List<Animal> animalList) {
    }

    @Override
    public Animal reproduce(Animal animal) {
        return null;
    }

    @Override
    public void moveDirection() {
    }

    @Override
    public void setIndex(int i, int j) {
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plants plants = (Plants) o;
        return Double.compare(plants.weight, weight) == 0 && maxAmountInCell == plants.maxAmountInCell && locIndexi == plants.locIndexi && locIndexj == plants.locIndexj && name.equals(plants.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, maxAmountInCell, locIndexi, locIndexj);
    }
}
