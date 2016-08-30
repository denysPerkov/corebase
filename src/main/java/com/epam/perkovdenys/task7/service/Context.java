package com.epam.perkovdenys.task7.service;


public class Context {

    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public void executeStrategy(){
        strategy.selectStrategy();
    }

}
