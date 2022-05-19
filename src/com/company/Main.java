package com.company;


import java.util.concurrent.*;


public class Main {

    public static void main(String[] args) throws InterruptedException {
        GetStatistics.getStatistics();
        Location.fillLocation();
        GetStatistics.getStatistics();

        while (true) {
            ExecutorService executorService = Executors.newCachedThreadPool();
            for (String cells : Location.loc.keySet()) {
                executorService.submit(new LifeCicle(cells));
            }
            executorService.submit(new GetStatistics());
            executorService.shutdownNow();
            executorService.awaitTermination(2000, TimeUnit.MILLISECONDS);
        }
    }
}
