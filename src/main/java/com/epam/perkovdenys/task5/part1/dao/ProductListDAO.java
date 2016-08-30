package com.epam.perkovdenys.task5.part1.dao;

import com.epam.perkovdenys.task5.part1.model.Food;

import java.util.List;

public interface ProductListDAO {

    void addProduct(Food food);

    void removeProduct(Food food);

    Food getProduct(Food food);

    Food getProductbyId(int id);

    List<Food> getAllFood();
}
