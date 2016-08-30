package com.epam.perkovdenys.task7.dao;

import com.epam.perkovdenys.task7.model.Food;

import java.util.List;

public interface RecentOrdersDAO {

    void addFoodToStorage(Food food);

    List<Food> get5thLast();
}
