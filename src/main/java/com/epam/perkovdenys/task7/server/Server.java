package com.epam.perkovdenys.task7.server;

import com.epam.perkovdenys.task7.utils.ServerConstants;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {

    private int port;

    public Server(int port) {
        this.port = port;
        setDaemon(true);
        start();
    }

    public void run() {
        System.out.println("Start server");
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            while (true) {
                Socket client = serverSocket.accept();
                System.out.printf("New client [%s] is conntected!%n", client.getPort());
                new Worker(client).start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void shutdownTCP(){
        try {
            new Socket(ServerConstants.HOST, ServerConstants.TCP_PORT).close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void shutdownHTTP(){
        try {
            new Socket(ServerConstants.HOST, ServerConstants.HTTP_PORT).close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
