package com.epam.perkovdenys.task7.commands;

import com.epam.perkovdenys.task7.service.CompositeContainer;

public interface Command {
    void execute(CompositeContainer compositeContainer);
}
