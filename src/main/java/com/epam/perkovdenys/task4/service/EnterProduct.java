package com.epam.perkovdenys.task4.service;


import com.epam.perkovdenys.task4.dao.impl.ProductsListDAOImpl;
import com.epam.perkovdenys.task4.model.Entree;
import com.epam.perkovdenys.task4.model.Food;
import com.epam.perkovdenys.task4.model.Potatoes;

import java.util.Scanner;

public class EnterProduct implements Strategy {

    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void selectStrategy() {
        selectProduct(scanner.nextLine());
    }



    private static void selectProduct(String name){
        switch (name){
            case "Food":{
                ProductsListDAOImpl.getInstance().addProduct(createFood());
                break;
            }
            case "Entree":{
                ProductsListDAOImpl.getInstance().addProduct(createEntree());
                break;
            }
            case "Potatoes": {
                ProductsListDAOImpl.getInstance().addProduct(createPotatoes());
                break;
            }
        }
    }

    private static Food createFood(){
        Food food = new Food();
        System.out.println("Input cost of product");
        food.setCost(scanner.nextInt());
        return food;
    }

    private static Entree createEntree(){
        Entree entree = new Entree();
        System.out.println("Input cost of product");
        entree.setCost(scanner.nextInt());
        System.out.println("Input colorik of product");
        System.out.println("Input minuts");
        entree.setMinuts(scanner.nextInt());
        return entree;
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
