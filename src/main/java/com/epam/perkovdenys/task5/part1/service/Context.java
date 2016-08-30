package com.epam.perkovdenys.task5.part1.service;


public class Context {

    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public void executeStrategy(){
        strategy.selectStrategy();
    }

}
