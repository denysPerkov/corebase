package com.epam.perkovdenys.task4.commands.impl;

import com.epam.perkovdenys.task4.commands.Command;
import com.epam.perkovdenys.task4.service.Facade;

public class PrintLastFiveOrderCommand implements Command {
    @Override
    public void execute(Facade facade) {
        facade.print5thLast();
    }
}
