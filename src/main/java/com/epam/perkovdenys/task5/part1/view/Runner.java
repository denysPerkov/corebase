package com.epam.perkovdenys.task5.part1.view;

import com.epam.perkovdenys.task5.part1.dao.impl.CommandsDAOImpl;
import com.epam.perkovdenys.task5.part1.dao.impl.ProductsListDAOImpl;
import com.epam.perkovdenys.task5.part1.service.CompositeContainer;

import java.io.IOException;
import java.util.Scanner;

public class Runner {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        CompositeContainer compositeContainer = new CompositeContainer();
        int input = -1;

       do{
            printComands();
            System.out.println("Select command");
            input = scanner.nextInt();
            scanner.nextLine();
            if (input == 0){
                break;
            }
            CommandsDAOImpl.getInstance().getCommand(input).execute(compositeContainer);

        }while(input != 0);

        ProductsListDAOImpl.getInstance().serializeProducts();
    }

    public static String readFromConsole(){
        return scanner.nextLine();
    }

    public static int readInteger(){
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }

    public static void print(String output){
        System.out.println(output);
    }

    private static void printComands(){
        System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        System.out.println("1. Display a list of products");
        System.out.println("2. Add food to basket");
        System.out.println("3. Print our basket");
        System.out.println("4. Buy all food");
        System.out.println("5. See the last five");
        System.out.println("6. Order the product");
        System.out.println("7. Print all orders by period");
        System.out.println("8. Print closest order");
        System.out.println("9. Add food to product list");
        System.out.println("0. Finish");
        System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
    }

    public static void printSelectTypes(){
        System.out.println("1. Generate automatically");
        System.out.println("2. Manually enter");
        System.out.println("3. Generate automatically by reflection");
        System.out.println("4. Manually enter by reflection");

    }
}
