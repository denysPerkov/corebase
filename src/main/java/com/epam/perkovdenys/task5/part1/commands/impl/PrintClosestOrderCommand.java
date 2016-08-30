package com.epam.perkovdenys.task5.part1.commands.impl;

import com.epam.perkovdenys.task5.part1.commands.Command;
import com.epam.perkovdenys.task5.part1.service.CompositeContainer;
import com.epam.perkovdenys.task5.part1.view.Runner;

public class PrintClosestOrderCommand implements Command {

    private String date;


    @Override
    public void execute(CompositeContainer compositeContainer) {
        Runner.print("Input date in format \"yyyy-MM-dd HH:mm\"");
        this.date = Runner.readFromConsole();
        compositeContainer.printClosestOrder(date);
    }
}
