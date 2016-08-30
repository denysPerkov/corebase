package com.epam.perkovdenys.task7.factory;

import com.epam.perkovdenys.task7.dao.impl.ProductsListDAOImpl;
import com.epam.perkovdenys.task7.interfaces.Getter;
import com.epam.perkovdenys.task7.model.Food;
import com.epam.perkovdenys.task7.utils.TCPCommands;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

public class TCPFactory extends AbstractFactory {

    private Socket client;

    public TCPFactory(Socket socket) {
        this.client = socket;
    }


    @Override
    public void handler() {
        BufferedReader reader = null;
        PrintWriter out = null;
        try {
            reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new PrintWriter(client.getOutputStream(), true);
            String clientMess = reader.readLine();
            out.println(getData(clientMess));
            out.flush();
            reader.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
             out.close();
        }
    }


    private String getData(String input) {

        if(TCPCommands.GET_COUNT.equals(input)){
            return String.valueOf(ProductsListDAOImpl.getInstance().getLastElement());
        }else if(input.contains(TCPCommands.GET_ITEM)){
            int number = Integer.parseInt(input.substring(input.indexOf("=") + 1));
            Food food = ProductsListDAOImpl.getInstance().getProductbyId(number);
            return getName(food).concat("|").concat(String.valueOf(food.getCost()));
        }

        return null;
    }

    private String getName(Food food)  {
        String name = null;
        for(Method method : food.getClass().getMethods())
            if(method.isAnnotationPresent(Getter.class)){
                try {
                    name = (String) method.invoke(food);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }

        return name;
    }
}
