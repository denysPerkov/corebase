package com.epam.perkovdenys.task7.dina;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class Worker extends Thread {

    private Socket client;

    public Worker(Socket client) {
        this.client = client;
    }

    public void run() {
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            in = new BufferedReader(new InputStreamReader(
                    client.getInputStream()));
            out = new PrintWriter(client.getOutputStream(), true);

            String mes = null;
            while (!"stop".equals(mes)) {
                mes = in.readLine();
                System.out.printf("Client [%s] says: %s%n", client.getPort(), mes);
                System.out.println("KEK = " + mes);
                out.println(mes);
            }
            in.close();
            out.close();
            client.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}