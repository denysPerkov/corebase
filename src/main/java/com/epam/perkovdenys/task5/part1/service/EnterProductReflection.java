package com.epam.perkovdenys.task5.part1.service;


import com.epam.perkovdenys.task5.part1.dao.impl.ProductsListDAOImpl;
import com.epam.perkovdenys.task5.part1.interfaces.ProductAccess;
import com.epam.perkovdenys.task5.part1.model.Food;
import com.epam.perkovdenys.task5.part1.view.Runner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class EnterProductReflection implements Strategy {

    private static Scanner scanner = new Scanner(System.in);
    private static final String BASE_NAME = "resources";
    private static final String PATH = "com.epam.perkovdenys.task5.part1.model.";

    @Override
    public void selectStrategy() {
        createProduct();
    }

    private static void createProduct()  {

        Scanner scanner = new Scanner(System.in);
        String name = PATH + Runner.readFromConsole();
        Class<? extends Food> clazz = null;
        try {
            clazz = (Class<? extends Food>) Class.forName(name);
            Food expectedObject = clazz.newInstance();

            Runner.print("Select language (en/ru)");
            String language = Runner.readFromConsole();
            Locale locale = new Locale(language);

            for (Method method :  clazz.getMethods()) {
                if (method.isAnnotationPresent(ProductAccess.class)) {
                    String key = method.getAnnotation(ProductAccess.class).name();
                    Class[] parameterTypes = method.getParameterTypes();

                    method.invoke(expectedObject, read(parameterTypes[0].getSimpleName(), locale, key));
                }
            }

            ProductsListDAOImpl.getInstance().addProduct(expectedObject);
        } catch (ClassNotFoundException e) {
            System.out.println("Invalid name, for example enter \"Potatoes\"");
            createProduct();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static Object read(String type, Locale locale, String key)  {

        Scanner scanner = new Scanner(System.in);
        ResourceBundle bundle = ResourceBundle.getBundle(BASE_NAME, locale);

        Runner.print(bundle.getString(key));

        if(type.equals("String")){
            return scanner.nextLine();
        }

        Class<Scanner> clazz = (Class<Scanner>) scanner.getClass();
        String nameScannerMethod = "next" + Character.toUpperCase(type.charAt(0)) + type.substring(1);

        try {
            Method method = clazz.getMethod(nameScannerMethod);
            return method.invoke(scanner);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return  null;
    }
}
