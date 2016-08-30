package com.epam.perkovdenys.task4.commands.impl;

import com.epam.perkovdenys.task4.commands.Command;
import com.epam.perkovdenys.task4.service.Facade;
import com.epam.perkovdenys.task4.view.Runner;

public class PrintClosestOrderCommand implements Command {

    private String date;


    @Override
    public void execute(Facade facade) {
        Runner.print("Input date in format \"yyyy-MM-dd HH:mm\"");
        this.date = Runner.readFromConsole();
        facade.printClosestOrder(date);
    }
}
