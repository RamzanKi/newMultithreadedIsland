package com.company.animals.predators;

import com.company.AnimalStat;
import com.company.animals.Animal;
import com.company.EmptySpace;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

import static com.company.AnimalStat.*;

public class Snake extends Predator {

    public Snake(int i, int j) {
        this.locIndexi = i;
        this.locIndexj = j;

        this.name = snakeName;
        this.weight = snakeWeight;
        this.maxAmountInCell = snakeMaxAmountInCell;
        this.maxSpeed = snakeMaxSpeed;
        this.foodForSatiety = snakeFoodForSatiety;
        this.numberOfMovesAfterHunger = snakeNumberOfMovesAfterHunger;
        this.starvationCount = snakeStarvationCount;
        this.weightLoss = snakeWeightLoss;
        this.chanceToEat = snakeChanceToEat;
    }

    @Override
    public Animal reproduce(Animal animal) {
        return new Snake(this.locIndexi, this.locIndexj);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Snake snake = (Snake) o;
        return Double.compare(snake.weight, weight) == 0 && maxAmountInCell == snake.maxAmountInCell && maxSpeed == snake.maxSpeed && Double.compare(snake.foodForSatiety, foodForSatiety) == 0 && numberOfMovesAfterHunger == snake.numberOfMovesAfterHunger && locIndexi == snake.locIndexi && locIndexj == snake.locIndexj && Double.compare(snake.satiety, satiety) == 0 && starvationCount == snake.starvationCount && Double.compare(snake.weightLoss, weightLoss) == 0 && name.equals(snake.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, maxAmountInCell, maxSpeed, foodForSatiety, numberOfMovesAfterHunger, locIndexi, locIndexj, satiety, starvationCount, weightLoss);
    }
}
