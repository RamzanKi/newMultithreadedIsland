package com.company;

import com.company.Animals.Animal;

import java.util.List;
import java.util.Objects;

public class EmptySpace extends Animal {
    private final String name = "-";
    private int locIndexi;
    private int locIndexj;

    public EmptySpace() {

    }

    public EmptySpace(int i, int j) {
        this.locIndexi = i;
        this.locIndexj = j;
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

    @Override
    public String getIndex() {
        return this.locIndexi +":"+ this.locIndexj;
    }

    public void setIndex(int i, int j) {
        this.locIndexi = i;
        this.locIndexj = j;
    }

    @Override
    public int getMaxAmountInCell() {
        return 0;
    }

    @Override
    public double getWeight() {
        return 0;
    }

    @Override
    public double getSatiety() {
        return 0;
    }

    @Override
    public void setSatiety(double satiety) {

    }

    @Override
    public void moveDirection() {
    }

    @Override
    public void eat(Animal animal, List<Animal> animalList) {
    }

    @Override
    public Animal reproduce(Animal animal) {
        return null;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmptySpace that = (EmptySpace) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
