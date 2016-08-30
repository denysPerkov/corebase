package com.epam.perkovdenys.task5.part1.dao;

import com.epam.perkovdenys.task5.part1.model.Food;

import java.util.Date;
import java.util.List;

public interface OrderProductDAO {

    void addOrderProduct(Date date, int number);

    List<Food> getOrdersByPeriod(String start, String finish);

    List<Food> getClosestOrder(String input);
}
