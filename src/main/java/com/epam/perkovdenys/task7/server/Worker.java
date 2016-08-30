package com.epam.perkovdenys.task7.server;

import com.epam.perkovdenys.task7.factory.AbstractFactory;
import com.epam.perkovdenys.task7.service.CompositeContainer;


import java.net.Socket;

class Worker extends Thread {

    private Socket client;

    public Worker(Socket client) {
        this.client = client;
    }


    public void run() {
       AbstractFactory abstractFactory = AbstractFactory.getFactory(client);
       abstractFactory.handler();
    }

}