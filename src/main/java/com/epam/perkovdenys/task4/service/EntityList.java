package com.epam.perkovdenys.task4.service;


import com.epam.perkovdenys.task4.model.Entree;
import com.epam.perkovdenys.task4.model.Food;
import com.epam.perkovdenys.task4.model.Potatoes;

import java.util.HashMap;
import java.util.Map;

public class EntityList {

    private static EntityList instance;
    private Map<String, Food> entityes;

    public EntityList(){
        entityes = new HashMap<>();
        initEntityes();
    }

    public static synchronized EntityList getInstance(){
        if(instance == null){
            instance = new EntityList();
        }

        return instance;
    }

    public Food getEntity(String name){
        return entityes.get(name);
    }


    private void initEntityes(){
        entityes.put("Food", new Food());
        entityes.put("Entree", new Entree());
        entityes.put("Potatoes", new Potatoes());
    }

}
