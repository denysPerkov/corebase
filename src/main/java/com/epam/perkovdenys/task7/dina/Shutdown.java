package com.epam.perkovdenys.task7.dina;

import java.io.IOException;
import java.net.Socket;

public class Shutdown {

    public static void main(String[] args) throws IOException {
        new Socket(Constants.HOST, Constants.ADMIN_PORT).close();
    }

}