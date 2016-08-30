package com.epam.perkovdenys.task4.dao;

import com.epam.perkovdenys.task4.model.Food;

import java.util.List;
import java.util.Map;

public interface RecentOrdersDAO {

    void addFoodToStorage(Food food);

    List<Food> get5thLast();
}
