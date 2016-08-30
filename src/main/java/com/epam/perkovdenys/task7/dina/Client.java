package com.epam.perkovdenys.task7.dina;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(Constants.HOST, Constants.PORT);

        BufferedReader in = null;
        BufferedReader stdin = null;
        PrintWriter out = null;
        try {
            stdin = new BufferedReader(new InputStreamReader(System.in));

            in = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));

            out = new PrintWriter(socket.getOutputStream(), true);

            System.out.printf("I am a client: %s (type 'stop' to exit)%n", socket.getLocalPort());
            String mes = null;
            while (!"stop".equals(mes)) {
                mes = stdin.readLine();
                out.println(mes.concat("MODNO"));
                System.out.println("Server says: " + in.readLine());
            }
            in.close();
            out.close();
            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}


