package com.company;

import com.company.Animals.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GetStatistics implements Runnable {
    public static int step;

    public static void getStatistics() {
        int wolfCount = 0, snakeCount = 0, sheepCount = 0, rabbitCount = 0, plantsCount = 0, kangarooCount = 0,
                horseCount = 0, hamsterCount = 0, goatCount = 0, foxCount = 0, eagleCount = 0, duckCount = 0,
                deerCount = 0, cowCount = 0, caterpillarCount = 0, bearCount = 0, emptySpaceCount = 0;
        for (List<Animal> animals : Location.loc.values()) {
            for (Animal animal : animals) {
                if (animal == null) {
                    continue;
                }
                switch (animal.getClass().getSimpleName()) {
                    case "Wolf" -> wolfCount++;
                    case "Snake" -> snakeCount++;
                    case "Sheep" -> sheepCount++;
                    case "Rabbit" -> rabbitCount++;
                    case "Plants" -> plantsCount++;
                    case "Kangaroo" -> kangarooCount++;
                    case "Horse" -> horseCount++;
                    case "Hamster" -> hamsterCount++;
                    case "Goat" -> goatCount++;
                    case "Fox" -> foxCount++;
                    case "Eagle" -> eagleCount++;
                    case "Duck" -> duckCount++;
                    case "Deer" -> deerCount++;
                    case "Cow" -> cowCount++;
                    case "Caterpillar" -> caterpillarCount++;
                    case "Bear" -> bearCount++;
                    case "EmptySpace" -> emptySpaceCount++;
                }
            }
        }
        System.out.println();
        System.out.println(" \uD83D\uDC3A : " + wolfCount + " \uD83D\uDC0D : " + snakeCount + " \uD83D\uDC11 : " + sheepCount + " \uD83D\uDC07 : " + rabbitCount + " \uD83C\uDF3F : " + plantsCount + " \uD83E\uDD98 : " + kangarooCount + " \uD83D\uDC0E : " +
                horseCount + " \uD83D\uDC39 : " + hamsterCount + " \uD83D\uDC10 : " + goatCount + " \uD83E\uDD8A : " + foxCount + " \uD83E\uDD85 : " + eagleCount + " \uD83E\uDD86 : " + duckCount + " \uD83E\uDD8C : " +
                deerCount + " \uD83D\uDC04 : " + cowCount + " \uD83D\uDC1B : " + caterpillarCount + " \uD83D\uDC3B : " + bearCount + " - : " + emptySpaceCount);
    }

    public static void print() {
        List<Animal> result = new CopyOnWriteArrayList<>();

        for (String s : Location.loc.keySet()) {
            String[] split = s.split(":");
            int i = Integer.parseInt(split[0]);
            int j = Integer.parseInt(split[1]);
            List<Animal> animals = Location.loc.get(s);
            animals.stream().filter(a -> a.getClass() != Plants.class &&
                            a.getClass() != EmptySpace.class &&
                            a.getClass() != Caterpillar.class &&
                            a.getClass() != Hamster.class &&
                            a.getClass() != Duck.class &&
                            a.getClass() != Goat.class &&
                            a.getClass() != Cow.class &&
                            a.getClass() != Rabbit.class &&
                            a.getClass() != Sheep.class).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .entrySet()
                    .stream()
                    .max(Map.Entry.comparingByValue())
                    .ifPresent(animalLongEntry -> result.add(animalLongEntry.getKey()));
            Location.island[i][j] = result.remove(0);
        }

        for (int i = 0; i < Location.island.length; i++) {
            for (int j = 0; j < Location.island[i].length; j++) {
                System.out.print(Location.island[i][j] + "    ");
            }
            System.out.println("   ");
        }
    }

    @Override
    public void run() {
        getStatistics();
        System.out.print("Starved to death : " + AnimalMovement.deathCount);
        System.out.print(" Born : " + AnimalReproducer.newBorn);
        System.out.println(" Step : " + ++step);
        print();
    }
}


