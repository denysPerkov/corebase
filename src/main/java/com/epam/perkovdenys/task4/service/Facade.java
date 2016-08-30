package com.epam.perkovdenys.task4.service;

import com.epam.perkovdenys.task4.dao.impl.OrderProductDAOImpl;
import com.epam.perkovdenys.task4.dao.impl.ProductsListDAOImpl;
import com.epam.perkovdenys.task4.dao.impl.RecentOrdersDAOImpl;
import com.epam.perkovdenys.task4.model.Food;
import com.epam.perkovdenys.task4.model.ShoppingBasket;
import com.epam.perkovdenys.task4.utils.DateUtil;

import java.util.Map;

public class Facade {

    private ShoppingBasket shopBasket;
    private OrderProductDAOImpl orderProducts;

    public Facade(){
        this.shopBasket = new ShoppingBasket();
        this.orderProducts = new OrderProductDAOImpl();
    }

    public void setShopBasket(ShoppingBasket obj){
        this.shopBasket = obj;
    }

    public void printAllProducts(){
        for(Food food :ProductsListDAOImpl.getInstance().getAllFood()){
            System.out.println("#" + food.getIdProduct() + " " + food);
        }
    }

    public void addProductToBasket(int number, int count){
        shopBasket.addProduct(number, count);
    }

    public void printBasket(){
        for (Map.Entry<Food, Integer> entry : shopBasket.getBasket().entrySet()){
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }
    }

    public int buyAllProducts(){
        return shopBasket.buyAllProducts();
    }

    public void print5thLast(){
       RecentOrdersDAOImpl.getInstance().get5thLast().forEach(System.out::println);
    }

    public void orderProduct(String date, int number){
        orderProducts.addOrderProduct(DateUtil.stringToDate(date), number);
    }

    public void printOrdersByPeriod(String start, String finish){
        for(Food food: orderProducts.getOrdersByPeriod(start, finish)){
            System.out.println(food);
        }
    }

    public void printClosestOrder(String date){
        System.out.println(orderProducts.getClosestOrder(date));
    }

    public void createProduct(Strategy strategy){
        Context context = new Context(strategy);
        context.executeStrategy();
    }

}
