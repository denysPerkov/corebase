package com.epam.perkovdenys.task4.dao;

import com.epam.perkovdenys.task4.model.Food;

import java.util.List;

public interface ProductListDAO {

    void addProduct(Food food);

    void removeProduct(Food food);

    Food getProduct(Food food);

    Food getProductbyId(int id);

    List<Food> getAllFood();
}
