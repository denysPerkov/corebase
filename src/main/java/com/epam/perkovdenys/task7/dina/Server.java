package com.epam.perkovdenys.task7.dina;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {

    private int port;

    public Server(int port) {
        this.port = port;

        // this current thread (server) is a daemon thread
        setDaemon(true);

        // a thread to listen admin port
        new Thread() {
            public void run() {
                try {
                    new ServerSocket(Constants.ADMIN_PORT).accept();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }.start();
    }

    public void run() {
        System.out
                .println("Server can be stopped with the help of: ./shutdown.bat command");
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            while (true) {
                Socket client = serverSocket.accept();
                System.out.printf("New client [%s] is conntected!%n",
                        client.getPort());
                new Worker(client).start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server(Constants.PORT);
        server.start();
    }

}