package com.epam.perkovdenys.task7.commands.impl;

import com.epam.perkovdenys.task7.commands.Command;
import com.epam.perkovdenys.task7.service.CompositeContainer;

public class PrintLastFiveOrderCommand implements Command {
    @Override
    public void execute(CompositeContainer compositeContainer) {
        compositeContainer.print5thLast();
    }
}
