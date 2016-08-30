package com.epam.perkovdenys.task4.service;



import com.epam.perkovdenys.task4.dao.impl.ProductsListDAOImpl;
import com.epam.perkovdenys.task4.model.Entree;
import com.epam.perkovdenys.task4.model.Food;
import com.epam.perkovdenys.task4.model.Potatoes;

import java.util.Scanner;

public class GenerateProduct implements Strategy {

    private GenerateProduct product;


    @Override
    public void selectStrategy() {
        Scanner scanner = new Scanner(System.in);
        generate(scanner.nextLine());
    }

    private static void generate(String name){

        switch (name){
            case "Food":{
                Food food = new Food();
                food.setCost((int) (Math.random()*100));
                ProductsListDAOImpl.getInstance().addProduct(food);
                break;
            }
            case "Entree":{
                Entree entree = new Entree();
                entree.setCost((int) (Math.random()*100));
                entree.setColorik((int) (Math.random()*100));
                entree.setMinuts((int) (Math.random() * 100));
                ProductsListDAOImpl.getInstance().addProduct(entree);
                break;
            }
            case "Potatoes": {
                Potatoes potatoes = new Potatoes();
                potatoes.setCost((int) (Math.random() * 100));
                potatoes.setColorik((int) (Math.random() * 100));
                potatoes.setMinuts((int) (Math.random() * 100));
                potatoes.setName("Potatoes".concat(String.valueOf((int) (Math.random() * 100))));
                ProductsListDAOImpl.getInstance().addProduct(potatoes);
                break;
            }
        }
    }
}
