package com.epam.perkovdenys.task5.part1.dao;

import com.epam.perkovdenys.task5.part1.model.Food;

import java.util.List;

public interface RecentOrdersDAO {

    void addFoodToStorage(Food food);

    List<Food> get5thLast();
}
