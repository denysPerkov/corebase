package com.epam.perkovdenys.task5.part1.commands.impl;

import com.epam.perkovdenys.task5.part1.commands.Command;
import com.epam.perkovdenys.task5.part1.service.CompositeContainer;
import com.epam.perkovdenys.task5.part1.view.Runner;

public class OrderProductCommand implements Command {

    private String dateOrder;
    private int productNumber;

    @Override
    public void execute(CompositeContainer compositeContainer) {
        Runner.print("Select product");
        this.productNumber = Runner.readInteger();
        Runner.print("Input date in format \"yyyy-MM-dd HH:mm\"");
        this.dateOrder = Runner.readFromConsole();
        compositeContainer.orderProduct(dateOrder, productNumber);
    }
}
