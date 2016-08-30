package com.epam.perkovdenys.task6.part_1_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LauncherCommonCollection {

    public static Thread[] initSingleThreads(int start, int finish, int countThread){
        Thread [] arr = new Thread[countThread];
        Thread thread;

        int real = finish - start;
        int last = real % countThread;
        int unit = real / countThread;

        for (int i = 0; i < countThread; i++, start += unit, last--) {
            if (last > 0) {
                thread = new Thread(new PrimeCommon(start, start + unit + 1));
                thread.start();
            } else {
                thread = new Thread(new PrimeCommon(start, start + unit));
                thread.start();
            }
            arr[i] = thread;
        }

        return arr;
    }

    public static void printPrimes() {
        for (Integer integer : PrimeCommon.getPrimeNumbers()) {
            System.out.print(integer + " ");
        }
    }

   private static class  PrimeCommon implements Runnable {

        private int start;
        private int finish;
        private static List<Integer> primeNumbers  = Collections.synchronizedList(new ArrayList<>());

        public PrimeCommon(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }

        @Override
        public void run() {
            for (int i = start; i <= finish; i++) {
                if (checkPrimeNumber(i)) {
                    primeNumbers.add(i);
                }
            }
        }

        public boolean checkPrimeNumber(int number) {
            if (number < 2) {
                return false;
            }
            for (int i = 2; i < number; i++) {
                if (number % i == 0)
                    return false;
            }

            return true;
        }

        public static List<Integer> getPrimeNumbers() {
            return primeNumbers;
        }
    }
}
