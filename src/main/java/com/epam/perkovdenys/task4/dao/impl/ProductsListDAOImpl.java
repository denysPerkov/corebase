package com.epam.perkovdenys.task4.dao.impl;

import com.epam.perkovdenys.task4.dao.ProductListDAO;
import com.epam.perkovdenys.task4.model.Food;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductsListDAOImpl implements ProductListDAO {

    private static ProductsListDAOImpl instance;
    private static List<Food> products;
    private static final String FILE_NAME = "product.res";

    private ProductsListDAOImpl(){
        products = new ArrayList<>();
        deSerializeProducts();
    }

    public static synchronized ProductsListDAOImpl getInstance(){
        if(instance == null){
            instance = new ProductsListDAOImpl();
        }

        return instance;
    }

    public void addProduct(Food food){
        products.add(food);
    }

    public void removeProduct(Food food){
        products.remove(food);
    }

    public Food getProduct(Food food){
        for(Food f : products){
            if(f.equals(food))
                return f;
        }

        return null;
    }

    public Food getProductbyId(int id){
        for(Food food : products){
            if(food.getIdProduct() == id)
                return food;
        }

        return null;
    }

    public List<Food> getAllFood(){
        return products;
    }

    public int getLastElement(){
        return products.size();
    }

    public  void serializeProducts(){
        try{
            FileOutputStream fos= new FileOutputStream(FILE_NAME);
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            oos.writeObject(products);
            oos.close();
            fos.close();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }

    public void deSerializeProducts(){
        try
        {
            FileInputStream fis = new FileInputStream(FILE_NAME);
            ObjectInputStream ois = new ObjectInputStream(fis);
            products = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
        }catch(IOException ioe){
            System.out.println("File not found");
        }catch(ClassNotFoundException c){
            c.printStackTrace();
            return;
        }

    }

    public void srlzSetNumbersOfTimes(int count){
        try{
            FileOutputStream fos= new FileOutputStream(FILE_NAME);
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            while(count > 0) {
                oos.writeObject(products);
                count--;
            }
            oos.close();
            fos.close();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}
