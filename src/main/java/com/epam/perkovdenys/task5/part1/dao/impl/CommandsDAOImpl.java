package com.epam.perkovdenys.task5.part1.dao.impl;

import com.epam.perkovdenys.task5.part1.commands.Command;
import com.epam.perkovdenys.task5.part1.commands.impl.*;
import com.epam.perkovdenys.task5.part1.dao.CommandsDAO;

import java.util.HashMap;
import java.util.Map;

public class CommandsDAOImpl implements CommandsDAO {

    private static CommandsDAOImpl instance = new CommandsDAOImpl();
    private static Map<Integer, Command> commands;

    private CommandsDAOImpl(){
        commands = new HashMap<>();
        initCommands();
    }

    public static CommandsDAOImpl getInstance(){
        return instance;
    }


    @Override
    public void addCommand(Integer commandNumb, Command command) {
        this.commands.put(commandNumb, command);
    }

    @Override
    public Command getCommand(Integer commandNumb) {
        if (commandNumb == null || !commands.containsKey(commandNumb)) {
            throw new IllegalArgumentException();
        }
        return this.commands.get(commandNumb);
    }

    private static void initCommands(){
        commands.put(1, new PrintProductListCommand());
        commands.put(2, new AddToBasketCommand());
        commands.put(3, new PrintBasketCommand());
        commands.put(4, new BuyBasketProductsCommand());
        commands.put(5, new PrintLastFiveOrderCommand());
        commands.put(6, new OrderProductCommand());
        commands.put(7, new PrintOrdersByPeiodCommand());
        commands.put(8, new PrintClosestOrderCommand());
        commands.put(9, new CreateProductCommand());
    }

}


