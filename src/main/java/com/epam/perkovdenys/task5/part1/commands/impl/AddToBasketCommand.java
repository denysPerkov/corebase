package com.epam.perkovdenys.task5.part1.commands.impl;

import com.epam.perkovdenys.task5.part1.commands.Command;
import com.epam.perkovdenys.task5.part1.service.CompositeContainer;
import com.epam.perkovdenys.task5.part1.view.Runner;

public class AddToBasketCommand implements Command {

    private int productNumber;
    private int count;


    @Override
    public void execute(CompositeContainer compositeContainer) {
        Runner.print("Input number of product");
        this.productNumber = Runner.readInteger();
        Runner.print("Input count of product");
        this.count = Runner.readInteger();
        compositeContainer.addProductToBasket(productNumber, count);
    }
}
