package com.epam.perkovdenys.task7.service;


import com.epam.perkovdenys.task7.dao.impl.ProductsListDAOImpl;
import com.epam.perkovdenys.task7.model.Meat;
import com.epam.perkovdenys.task7.model.Potatoes;

import java.util.Scanner;

public class EnterProduct implements Strategy {

    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void selectStrategy() {
        selectProduct(scanner.nextLine());
    }



    private static void selectProduct(String name){
        switch (name){
           case "Meat":{
                ProductsListDAOImpl.getInstance().addProduct(createMeat());
                break;
            }
            case "Potatoes": {
                ProductsListDAOImpl.getInstance().addProduct(createPotatoes());
                break;
            }
            default:{
                System.out.println("Invalid name, for example enter \"Potatoes\"");
                Scanner scanner = new Scanner(System.in);
                selectProduct(scanner.nextLine());
            }
        }
    }

    private static Meat createMeat(){
        Meat meat = new Meat();
        System.out.println("Input cost of product");
        meat.setCost(scanner.nextInt());
        System.out.println("Input colorik of product");
        meat.setColorik(scanner.nextInt());
        System.out.println("Input minuts");
        meat.setMinuts(scanner.nextInt());
        System.out.println("Input name");
        scanner.nextLine();
        meat.setName(scanner.nextLine());
        return meat;
    }

    private static Potatoes createPotatoes(){
        Potatoes potatoes = new Potatoes();
        System.out.println("Input cost of product");
        potatoes.setCost(scanner.nextInt());
        System.out.println("Input colorik of product");
        potatoes.setColorik(scanner.nextInt());
        System.out.println("Input minuts");
        potatoes.setMinuts(scanner.nextInt());
        System.out.println("Input name");
        scanner.nextLine();
        potatoes.setName(scanner.nextLine());
        return potatoes;
    }
}
