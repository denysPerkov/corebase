package com.epam.perkovdenys.task5.part1.commands.impl;

import com.epam.perkovdenys.task5.part1.commands.Command;
import com.epam.perkovdenys.task5.part1.service.*;
import com.epam.perkovdenys.task5.part1.view.Runner;

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
        }else if(input == 3){
            Runner.print("Input type of product");
            this.strategy = new GenerateProductReflection();
        }else if(input == 4){
            Runner.print("Input type of product");
            this.strategy = new EnterProductReflection();
        }
    }

    @Override
    public void execute(CompositeContainer compositeContainer) {
        setStrategy();
        compositeContainer.createProduct(strategy);
    }
}
