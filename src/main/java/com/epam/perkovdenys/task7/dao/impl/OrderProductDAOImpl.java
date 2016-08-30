package com.epam.perkovdenys.task7.dao.impl;


import com.epam.perkovdenys.task7.dao.OrderProductDAO;
import com.epam.perkovdenys.task7.model.Food;
import com.epam.perkovdenys.task7.utils.DateUtil;

import java.util.*;

public class OrderProductDAOImpl implements OrderProductDAO {

    private Map<Date, List<Food>> orderedProd;

    public OrderProductDAOImpl(){
        orderedProd = new TreeMap<>();
    }

    public void addOrderProduct(Date date, int number){
        List<Food> foods;
        if (orderedProd.containsKey(date)){
            foods = orderedProd.get(date);
            foods.add(ProductsListDAOImpl.getInstance().getProductbyId(number));
            orderedProd.put(date, foods);
        }else {
            foods = new ArrayList<>();
            foods.add(ProductsListDAOImpl.getInstance().getProductbyId(number));
            orderedProd.put(date, foods);
        }

    }

    public List<Food> getOrdersByPeriod(String start, String finish){
        List<Food> products = new ArrayList<>();
        for (Map.Entry<Date, List<Food>> entry : orderedProd.entrySet())
        {
          if(DateUtil.compareDates(entry.getKey(), start, finish)){
              products.addAll(entry.getValue());
          }
        }

        return products;
    }

    public List<Food> getClosestOrder(String input){
        Date date = null;
        long count = Long.MAX_VALUE;
        for (Map.Entry<Date, List<Food>> entry : orderedProd.entrySet())
        {
         if(DateUtil.differeceDates(entry.getKey(), input) < count && (count != 0) ){
                date = entry.getKey();
                count = DateUtil.differeceDates(entry.getKey(), input);
           }
        }

        return orderedProd.get(date);
    }
}
