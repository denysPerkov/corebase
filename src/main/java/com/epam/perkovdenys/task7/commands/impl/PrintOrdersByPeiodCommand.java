package com.epam.perkovdenys.task7.commands.impl;

import com.epam.perkovdenys.task7.commands.Command;
import com.epam.perkovdenys.task7.service.CompositeContainer;
import com.epam.perkovdenys.task7.view.Runner;

public class PrintOrdersByPeiodCommand implements Command {

    private String start;
    private String finish;


    @Override
    public void execute(CompositeContainer compositeContainer) {
        Runner.print("Input start date in format \"yyyy-MM-dd HH:mm\"");
        this.start = Runner.readFromConsole();
        Runner.print("Input finish date in format \"yyyy-MM-dd HH:mm\"");
        this.finish = Runner.readFromConsole();
        compositeContainer.printOrdersByPeriod(start, finish);
    }
}
