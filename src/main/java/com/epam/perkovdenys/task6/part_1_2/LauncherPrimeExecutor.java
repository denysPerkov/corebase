package com.epam.perkovdenys.task6.part_1_2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LauncherPrimeExecutor {

    public static void initExecutors(int start, int finish, int countThread){
        ExecutorService executor = Executors.newFixedThreadPool(countThread);

        int real = finish - start;
        int last = real % countThread;
        int unit = real / countThread;

        for (int i = 0; i < countThread; i++, start += unit, last--) {
            if (last > 0) {
                Runnable runnable = new PrimeSingle(start, start + unit + 1);
                executor.execute(runnable);
            } else {
                Runnable runnable = new PrimeSingle(start, start + unit);
                executor.execute(runnable);
            }
        }

        executor.shutdown();
        while (!executor.isTerminated()) {}
    }

    public static void printPrimes() {
        for (Integer integer : PrimeSingle.getPrimeNumbers()) {
            System.out.print(integer + " ");
        }
    }
    private static class PrimeSingle implements Runnable{

        private int start;
        private int finish;
        private static List<Integer> primeNumbers  = Collections.synchronizedList(new ArrayList<>());

        public PrimeSingle(int start, int finish){
            this.start = start;
            this.finish = finish;
        }

        @Override
        public void run() {
            List<Integer> numbers = new ArrayList<>();
            for(int i = start; i <= finish; i++){
                if(checkPrimeNumber(i)){
                    numbers.add(i);
                }
            }
            primeNumbers.addAll(numbers);
        }

        public boolean checkPrimeNumber(int number){
            if(number < 2){
                return false;
            }
            for(int i = 2; i < number; i++){
                if(number % i == 0)
                    return false;
            }
            return true;
        }

        public static List<Integer> getPrimeNumbers(){
            return primeNumbers;
        }
    }


}
