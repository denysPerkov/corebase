package com.epam.perkovdenys.task7.service;



import com.epam.perkovdenys.task7.dao.impl.ProductsListDAOImpl;
import com.epam.perkovdenys.task7.model.Meat;
import com.epam.perkovdenys.task7.model.Potatoes;

import java.util.Scanner;

public class GenerateProduct implements Strategy {


    @Override
    public void selectStrategy() {
        Scanner scanner = new Scanner(System.in);
        generate(scanner.nextLine());
    }

    private static void generate(String name){

        switch (name){
            case "Meat": {
                Meat meat = new Meat();
                meat.setCost((int) (Math.random() * 100));
                meat.setColorik((int) (Math.random() * 100));
                meat.setMinuts((int) (Math.random() * 100));
                meat.setName("Meat".concat(String.valueOf((int) (Math.random() * 100))));
                ProductsListDAOImpl.getInstance().addProduct(meat);
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
            default:{
                System.out.println("Invalid name, for example enter \"Potatoes\"");
                Scanner scanner = new Scanner(System.in);
                generate(scanner.nextLine());
            }
        }
    }
}
