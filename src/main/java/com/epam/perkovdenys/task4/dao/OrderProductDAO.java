package com.epam.perkovdenys.task4.dao;

import com.epam.perkovdenys.task4.model.Food;

import java.util.Date;
import java.util.List;

public interface OrderProductDAO {

    void addOrderProduct(Date date, int number);

    List<Food> getOrdersByPeriod(String start, String finish);

    List<Food> getClosestOrder(String input);
}
