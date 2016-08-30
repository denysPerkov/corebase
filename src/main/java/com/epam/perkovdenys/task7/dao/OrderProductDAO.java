package com.epam.perkovdenys.task7.dao;

import com.epam.perkovdenys.task7.model.Food;

import java.util.Date;
import java.util.List;

public interface OrderProductDAO {

    void addOrderProduct(Date date, int number);

    List<Food> getOrdersByPeriod(String start, String finish);

    List<Food> getClosestOrder(String input);
}
