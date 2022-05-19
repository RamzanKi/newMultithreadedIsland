package com.company.animals;

import java.util.List;

public class Brick extends Animal {
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
        return null;
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


}
