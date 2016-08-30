package com.epam.perkovdenys.task4.commands.impl;

import com.epam.perkovdenys.task4.commands.Command;
import com.epam.perkovdenys.task4.model.Food;
import com.epam.perkovdenys.task4.service.EnterProduct;
import com.epam.perkovdenys.task4.service.Facade;
import com.epam.perkovdenys.task4.service.GenerateProduct;
import com.epam.perkovdenys.task4.service.Strategy;
import com.epam.perkovdenys.task4.view.Runner;

public class CreateProductCommand implements Command {

    private Strategy strategy;
    private static int input;

    public void setStrategy(){
        if(input == 0){
            Runner.printSelectTypes();
            input = Runner.readInteger();
        }
        if(input == 1){
            Runner.print("Input type of product");
            this.strategy = new GenerateProduct();
        }else if(input == 2){
            Runner.print("Input type of product");
            this.strategy = new EnterProduct();
        }
    }

    @Override
    public void execute(Facade facade) {
        setStrategy();
        facade.createProduct(strategy);
    }
}
