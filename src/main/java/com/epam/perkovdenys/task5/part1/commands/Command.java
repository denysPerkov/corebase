package com.epam.perkovdenys.task5.part1.commands;

import com.epam.perkovdenys.task5.part1.service.CompositeContainer;

public interface Command {
    void execute(CompositeContainer compositeContainer);
}
