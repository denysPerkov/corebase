package com.epam.perkovdenys.task4.commands.impl;

import com.epam.perkovdenys.task4.commands.Command;
import com.epam.perkovdenys.task4.service.Facade;
import com.epam.perkovdenys.task4.view.Runner;

public class PrintOrdersByPeiodCommand implements Command {

    private String start;
    private String finish;


    @Override
    public void execute(Facade facade) {
        Runner.print("Input start date in format \"yyyy-MM-dd HH:mm\"");
        this.start = Runner.readFromConsole();
        Runner.print("Input finish date in format \"yyyy-MM-dd HH:mm\"");
        this.finish = Runner.readFromConsole();
        facade.printOrdersByPeriod(start, finish);
    }
}
