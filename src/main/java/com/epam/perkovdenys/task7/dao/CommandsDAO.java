package com.epam.perkovdenys.task7.dao;

import com.epam.perkovdenys.task7.commands.Command;

public interface CommandsDAO {

    void addCommand(Integer commandNumb, Command command);

    Command getCommand(Integer commandNumb);

}
