package com.epam.perkovdenys.task4.commands.impl;


import com.epam.perkovdenys.task4.commands.Command;
import com.epam.perkovdenys.task4.service.Facade;
import com.epam.perkovdenys.task4.view.Runner;

public class PrintProductListCommand implements Command {

    @Override
    public void execute(Facade facade) {
        facade.printAllProducts();
    }
}
