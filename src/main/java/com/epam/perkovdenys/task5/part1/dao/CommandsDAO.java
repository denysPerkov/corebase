package com.epam.perkovdenys.task5.part1.dao;

import com.epam.perkovdenys.task5.part1.commands.Command;

public interface CommandsDAO {

    void addCommand(Integer commandNumb, Command command);

    Command getCommand(Integer commandNumb);

}
