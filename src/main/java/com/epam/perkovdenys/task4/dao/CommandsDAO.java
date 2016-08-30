package com.epam.perkovdenys.task4.dao;

import com.epam.perkovdenys.task4.commands.Command;

import java.util.Collections;

public interface CommandsDAO {

    void addCommand(Integer commandNumb, Command command);

    void removeCommand(Integer commandNumb);

    Command getCommand(Integer commandNumb);

}
