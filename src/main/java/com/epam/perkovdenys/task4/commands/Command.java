package com.epam.perkovdenys.task4.commands;

import com.epam.perkovdenys.task4.service.Facade;

public interface Command {
    void execute(Facade facade);
}
