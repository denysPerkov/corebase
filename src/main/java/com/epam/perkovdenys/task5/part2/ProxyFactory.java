package com.epam.perkovdenys.task5.part2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {

    public static Object newInstance(Object obj){
        return  Proxy.newProxyInstance(obj.getClass().getClassLoader(), new Class<?>[]{Potatoes.class},
                new MyInvocationHandler(obj));
    }

    private static class MyInvocationHandler implements InvocationHandler {

        private Object obj;

        public MyInvocationHandler(Object obj){
            this.obj = obj;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if(method.getName().startsWith("set")) {
                throw new IllegalArgumentException();
            }

            return method.invoke(obj, args);
        }
    }

}
