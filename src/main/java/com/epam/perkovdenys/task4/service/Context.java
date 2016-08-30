package com.epam.perkovdenys.task4.service;


import com.epam.perkovdenys.task4.model.Food;

public class Context {

    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public void executeStrategy(){
        strategy.selectStrategy();
    }

}
