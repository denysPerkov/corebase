package com.epam.perkovdenys.task5.part1.model;


import com.epam.perkovdenys.task5.part1.dao.impl.ProductsListDAOImpl;
import com.epam.perkovdenys.task5.part1.dao.impl.RecentOrdersDAOImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingBasket {

    private Map<Food, Integer> basket;

    public ShoppingBasket(){
        basket = new HashMap<Food, Integer>();
    }

    public void addProduct(int number){
        int previusCount = 0;

        for(Food food : ProductsListDAOImpl.getInstance().getAllFood()){
           if(food.getIdProduct() == number){
               number = food.getIdProduct();
           }
        }
        previusCount++;
        basket.put( ProductsListDAOImpl.getInstance().getProductbyId(number), previusCount);
    }

    public void addProduct(int number, int count){
        int previusCount = 0;
        Food fd = ProductsListDAOImpl.getInstance().getProductbyId(number);
        if(basket.get(fd) != null){
            for(Integer it : basket.values()){
                previusCount += it;
            }
        }

        for(Food food : ProductsListDAOImpl.getInstance().getAllFood()){
            if(food.getIdProduct() == number){
                number = food.getIdProduct();
            }
        }
        count += previusCount;
        basket.put( ProductsListDAOImpl.getInstance().getProductbyId(number), count);
    }

    public void removeProduct(int id){
        int count = basket.get(ProductsListDAOImpl.getInstance().getProductbyId(id));
        basket.remove(ProductsListDAOImpl.getInstance().getProductbyId(id));
    }

    public void clearBasket(){
        basket.clear();
    }

    public Map<Food, Integer> getBasket(){
        return basket;
    }

    public int buyAllProducts(){
        int sum = 0;
        for (Map.Entry<Food, Integer> entry : basket.entrySet())
        {
            RecentOrdersDAOImpl.getInstance().addFoodToStorage(entry.getKey());           ;
            sum += entry.getValue() * entry.getKey().getCost();
        }


        clearBasket();
        return sum;
    }

    public List<Food> getListFood(){
        List<Food> foods = new ArrayList<>(getBasket().keySet());
        return foods;
    }
 }
