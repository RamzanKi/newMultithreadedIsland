package com.company.Animals;

import java.util.List;

public abstract class Animal {
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

    public abstract double getFoodForSatiety();
    public abstract int getNumberOfMovesAfterHunger();
    public abstract int getStarvationCount();
    public abstract void setStarvationCount(int starvationCount);
    public abstract double getWeightLoss();
    public abstract void setWeightLoss(double weightLoss);
    public abstract String getIndex();
    public abstract void eat(Animal animal, List<Animal> animalList);
    public abstract Animal reproduce(Animal animal);
    public abstract void moveDirection();
    public abstract void setIndex(int i, int j);
    public abstract int getMaxAmountInCell();
    public abstract double getWeight();
    public abstract double getSatiety();
    public abstract void setSatiety(double satiety);

    @Override
    public String toString() {
        return name;
    }
}
