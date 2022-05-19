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
    }

    @Override
    public void eat(Animal animal, List<Animal> animalList) {
        String simpleName = animal.getClass().getSimpleName();
        int chance = 0;
        switch (simpleName){
            case "Wolf" -> chance = 0;
            case "Snake" -> chance = 0;
            case "Sheep" -> chance = 0;
            case "Rabbit" -> chance = 7;
            case "Kangaroo" -> chance = 0;
            case "Horse" -> chance = 0;
            case "Hamster" -> chance = 9;
            case "Goat" -> chance = 0;
            case "Fox" -> chance = 3;
            case "Eagle" -> chance = 0;
            case "Duck" -> chance = 5;
            case "Deer" -> chance = 0;
            case "Cow" -> chance = 0;
            case "Caterpillar" -> chance = 9;
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
