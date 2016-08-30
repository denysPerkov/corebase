package com.epam.perkovdenys.task6.part_1_2;

import java.util.Scanner;

public class Runner {

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter start");
        int start = scanner.nextInt();
        System.out.println("Enter finish");
        int finish = scanner.nextInt();
        System.out.println("Enter count of threads");
        int countThread = scanner.nextInt();

        long beginTime = System.currentTimeMillis();
        for(Thread thread : LauncherCommonCollection.initSingleThreads(start, finish, countThread)) {
            thread.join();
        }
        LauncherCommonCollection.printPrimes();
        System.out.println("\nTime = " + (System.currentTimeMillis() - beginTime) + "(ms)" + " using a common collection");


        beginTime = System.currentTimeMillis();
        for(Thread thread : LauncherSingleCollection.initThreads(start, finish, countThread))
            thread.join();
        LauncherSingleCollection.printPrimes();
        System.out.println("\nTime = " + (System.currentTimeMillis() - beginTime) + "ms" + " using a single collections");

        beginTime = System.currentTimeMillis();
        LauncherPrimeExecutor.initExecutors(start, finish, countThread);
        LauncherPrimeExecutor.printPrimes();
        System.out.println("\nTime = " + (System.currentTimeMillis() - beginTime) + "(ms)" + " using executors");
    }
}
