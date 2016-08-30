package com.epam.perkovdenys.task4.dao.impl;

import com.epam.perkovdenys.task4.commands.Command;
import com.epam.perkovdenys.task4.commands.impl.*;
import com.epam.perkovdenys.task4.dao.CommandsDAO;

import java.util.HashMap;

public class CommandsDAOImpl implements CommandsDAO {

    private static CommandsDAOImpl instance;
    private static HashMap<Integer, Command> commands;

    private CommandsDAOImpl(){
        commands = new HashMap<>();
        initCommands();
    }

    public static synchronized CommandsDAOImpl getInstance(){
        if(instance == null){
            instance = new CommandsDAOImpl();
        }

        return instance;
    }


    @Override
    public void addCommand(Integer commandNumb, Command command) {
        this.commands.put(commandNumb, command);
    }

    @Override
    public void removeCommand(Integer commandNumb) {
        this.commands.remove(commandNumb);
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


