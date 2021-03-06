package com.epam.perkovdenys.task4.dao.impl;

import com.epam.perkovdenys.task4.dao.RecentOrdersDAO;

import com.epam.perkovdenys.task4.model.Food;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class RecentOrdersDAOImpl extends LinkedHashMap<Integer, Food> implements RecentOrdersDAO {

    private static final int SIZE = 5;
    private static final AtomicInteger count = new AtomicInteger(0);
    private static RecentOrdersDAOImpl instance;
    private Map<Integer, Food> storage;


    public RecentOrdersDAOImpl(){
        storage = new LinkedHashMap<Integer, Food>();
    }

    public static synchronized RecentOrdersDAOImpl getInstance(){
        if(instance == null){
            instance = new RecentOrdersDAOImpl();
        }

        return instance;
    }

    public void addFoodToStorage(Food food){
        storage.put(count.incrementAndGet(), food);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer,Food> eldest) {
        return size() > SIZE;
    }

    public List<Food> get5thLast(){
       return new ArrayList<>(storage.values());
    }
}
