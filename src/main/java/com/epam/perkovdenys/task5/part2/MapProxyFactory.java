package com.epam.perkovdenys.task5.part2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class MapProxyFactory {

    public static Object newInstance(Object obj){
        return  Proxy.newProxyInstance(obj.getClass().getClassLoader(), new Class<?>[]{Potatoes.class},
                new MapInvocationHandler(obj));
    }

    private static class MapInvocationHandler implements InvocationHandler {

        Map<String, Object> properties;
        private Object product;

        public MapInvocationHandler(Object object) {
            this.product = object;
            properties = new HashMap<String, Object>();
            initMap();
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            String key = method.getName().substring(3);

            if(method.getName().startsWith("set")) {
                return properties.put(key, args[0]);
            }

            return properties.get(key);
        }

        private void initMap()  {
            Class<?> clazz =  product.getClass();
            for(Method method : clazz.getMethods()){
                if(method.getName().startsWith("get")){
                    String key = method.getName().substring(3);
                    Object o = null;

                    try {
                        o = method.invoke(product, null);
                        properties.put(key, o);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }


}
