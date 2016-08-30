package com.epam.perkovdenys.task4.commands.impl;

import com.epam.perkovdenys.task4.commands.Command;
import com.epam.perkovdenys.task4.service.Facade;
import com.epam.perkovdenys.task4.view.Runner;

public class OrderProductCommand implements Command {

    private String dateOrder;
    private int productNumber;

    @Override
    public void execute(Facade facade) {
        Runner.print("Select product");
        this.productNumber = Runner.readInteger();
        Runner.print("Input date in format \"yyyy-MM-dd HH:mm\"");
        this.dateOrder = Runner.readFromConsole();
        facade.orderProduct(dateOrder, productNumber);
    }
}
