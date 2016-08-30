package com.epam.perkovdenys.task6.part3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.*;

public class Runner {

    public static void main(String[] args) throws Exception {

        do {
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            Exchanger exchanger = new Exchanger();
            SequnceByte sequnceByte = new SequnceByte(exchanger);
            Future future = executorService.submit(sequnceByte);
            System.out.println("The second thread started");

            byte[] data = getDataFromFile();
            exchanger.exchange(data);


            while (!future.isDone()) {
                Object object = exchanger.exchange(true);
                if (object == Status.DONE) {
                    break;
                }

                System.out.print(object + " ");
            }

            int[] sequnceFeature = (int[]) future.get();
            System.out.println("\nLength = " + sequnceFeature[0] + " Index of first = " + sequnceFeature[1] +
                    " Index of last = " + sequnceFeature[2]);
            executorService.shutdown();
            executorService.shutdownNow();

        }while(select() == 1);
    }

    private static byte[] getDataFromFile() throws IOException {
        System.out.println("Enter file name for example \"myfile.txt\"");
        Scanner scanner = new Scanner(System.in);
        Path path = Paths.get(scanner.nextLine());

        return Files.readAllBytes(path);
    }

    private static int select(){
        System.out.println("Do you want to continue (0|1)?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}
