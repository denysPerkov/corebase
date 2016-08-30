package com.epam.perkovdenys.task5.part1.commands.impl;


import com.epam.perkovdenys.task5.part1.commands.Command;
import com.epam.perkovdenys.task5.part1.service.CompositeContainer;

public class PrintProductListCommand implements Command {

    @Override
    public void execute(CompositeContainer compositeContainer) {
        compositeContainer.printAllProducts();
    }
}
