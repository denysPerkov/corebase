package com.epam.perkovdenys.task4.commands.impl;

import com.epam.perkovdenys.task4.commands.Command;
import com.epam.perkovdenys.task4.service.Facade;
import com.epam.perkovdenys.task4.view.Runner;

public class AddToBasketCommand implements Command {

    private int productNumber;
    private int count;


    @Override
    public void execute(Facade facade) {
        Runner.print("Input number of product");
        this.productNumber = Runner.readInteger();
        Runner.print("Input count of product");
        this.count = Runner.readInteger();
        facade.addProductToBasket(productNumber, count);
    }
}
