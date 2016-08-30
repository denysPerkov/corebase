package com.epam.perkovdenys.task7.factory;

import com.epam.perkovdenys.task7.dao.impl.ProductsListDAOImpl;
import com.epam.perkovdenys.task7.interfaces.Getter;
import com.epam.perkovdenys.task7.model.Food;
import com.epam.perkovdenys.task7.utils.URLCommands;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

public class HTTPFactory extends AbstractFactory {

    private Socket client;
    private InputStream inputStream;
    private OutputStream outputStream;

    public HTTPFactory(Socket socket){
        this.client = socket;
    }

    @Override
    public void handler() {

       try {
            inputStream = client.getInputStream();
            outputStream = client.getOutputStream();
            String str = readInputHeaders();
            String command = selectCommand(str);
            writeResponse(command);
            inputStream.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void writeResponse(String s) throws IOException {
        String response = "HTTP/1.1 200 OK\r\n" +
                "Server: MyServer\r\n" +
                "Content-Type: text/html\r\n" +
                "Connection: close\r\n\r\n";
        String result = response + s;
        outputStream.write(result.getBytes());
        outputStream.flush();
        outputStream.close();
    }

    private String readInputHeaders() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        return reader.readLine();
    }

    private String selectCommand(String command) {
        StringBuilder sb = new StringBuilder();
        if (command.equals(URLCommands.GET_COUNT)) {
            sb.append("{count:");
            sb.append(String.valueOf(ProductsListDAOImpl.getInstance().getLastElement()) + "}");
            return sb.toString();

        }

        if(command.contains(URLCommands.GET_PRODUCT)){
            int firstIndex = command.indexOf("=") + 1;
            int lastIndex = command.lastIndexOf(" ");
            int numbProduct = Integer.parseInt(command.substring(firstIndex, lastIndex));

            String name = getName(ProductsListDAOImpl.getInstance().getProductbyId(numbProduct));
            sb.append("{name: " + name);
            int cost = ProductsListDAOImpl.getInstance().getProductbyId(numbProduct).getCost();
            sb.append(", price" + cost + "}");
            return sb.toString();
        }

        return URLCommands.FAIL_COMMAND;
    }

    private String getName(Food food)  {
         for(Method method : food.getClass().getMethods())
            if(method.isAnnotationPresent(Getter.class)){
                try {
                    return  (String) method.invoke(food);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }

        return null;
    }
}
