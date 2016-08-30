package com.epam.perkovdenys.task7.server;


import com.epam.perkovdenys.task7.utils.ServerConstants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

   private BufferedReader in = null;
   private BufferedReader stdin = null;
   private PrintWriter out = null;
   private Socket socket;

    Client() throws IOException {
        socket = new Socket(ServerConstants.HOST, ServerConstants.TCP_PORT);
        stdin = new BufferedReader(new InputStreamReader(System.in));
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
    }

    public static void main(String[] args) throws IOException {
       Client client = new Client();

        try {
           /// System.out.printf("I am a client: %s (type 'stop' to exit)%n", obj.socket.getLocalPort());


            //client.out.println(client.stdin.readLine());
            client.out.println(client.readCommand());
            System.out.println("From server: " + client.in.readLine());

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
           client.in.close();
           client.out.close();
           client.socket.close();
        }
    }

    public String readCommand() throws IOException {
        return stdin.readLine();
    }




}
