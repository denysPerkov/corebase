package com.epam.perkovdenys.task7.service;


import com.epam.perkovdenys.task7.dao.impl.ProductsListDAOImpl;
import com.epam.perkovdenys.task7.interfaces.ProductAccess;
import com.epam.perkovdenys.task7.model.Food;
import com.epam.perkovdenys.task7.view.Runner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;
import java.util.Scanner;

public class GenerateProductReflection implements Strategy {

    private static final String PATH = "com.epam.perkovdenys.task7.model.";

    @Override
    public void selectStrategy() {
      generate();
    }

    private static void generate() {
        Scanner scanner = new Scanner(System.in);
        String name = PATH + Runner.readFromConsole();
        Class<? extends Food> clazz = null;
        try {
            clazz = (Class<? extends Food>) Class.forName(name);
            Food expectedObject = clazz.newInstance();


            for (Method method :  clazz.getMethods()) {
                if (method.isAnnotationPresent(ProductAccess.class)) {
                    String key = method.getAnnotation(ProductAccess.class).name();
                    Class[] parameterTypes = method.getParameterTypes();

                    method.invoke(expectedObject, randomField(parameterTypes[0].getSimpleName()));
                }
            }

            ProductsListDAOImpl.getInstance().addProduct(expectedObject);
        } catch (ClassNotFoundException e) {
            System.out.println("Invalid name, for example enter \"Potatoes\"");
            generate();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static Object randomField(String type){
        Random random = new Random();

        if(type.equals("String")){
            return "Food" + Math.abs(random.nextInt());
        }

        Class<Random> clazz = (Class<Random>) random.getClass();
        String nameRandomMethod = "next" + Character.toUpperCase(type.charAt(0)) + type.substring(1);

        Method method = null;
        try {
            method = clazz.getMethod(nameRandomMethod);
            return Math.abs((Integer) method.invoke(random));

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }
}