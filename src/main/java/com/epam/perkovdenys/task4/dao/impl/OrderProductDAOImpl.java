package com.epam.perkovdenys.task4.dao.impl;


import com.epam.perkovdenys.task4.dao.OrderProductDAO;
import com.epam.perkovdenys.task4.model.Food;
import com.epam.perkovdenys.task4.utils.DateUtil;

import java.util.*;

public class OrderProductDAOImpl implements OrderProductDAO {

    private Map<Date, List<Food>> orderedProd;

    public OrderProductDAOImpl(){
        orderedProd = new TreeMap<>();
    }

    public void addOrderProduct(Date date, int number){
        List<Food> list;
        if (orderedProd.containsKey(date)){
            list = orderedProd.get(date);
            list.add(ProductsListDAOImpl.getInstance().getProductbyId(number));
            orderedProd.put(date, list);
        }else {
            list = new ArrayList<>();
            list.add(ProductsListDAOImpl.getInstance().getProductbyId(number));
            orderedProd.put(date, list);
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
