package com.epam.perkovdenys.task7.factory;

import com.epam.perkovdenys.task7.utils.ServerConstants;

import java.net.Socket;


public abstract class AbstractFactory {

    public static AbstractFactory getFactory(Socket client){
        if(client.getLocalPort() == ServerConstants.TCP_PORT){
            return new TCPFactory(client);
        } else if(client.getLocalPort() == ServerConstants.HTTP_PORT){
            return new HTTPFactory(client);
        }

        return null;
    }

    public abstract void handler();

}
