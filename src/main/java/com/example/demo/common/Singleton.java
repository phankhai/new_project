package com.example.demo.common;

import java.util.HashMap;
import java.util.Map;

public class Singleton {

    private static final Singleton instance = new Singleton();

    @SuppressWarnings("rawtypes")
    private final Map<Class,Object> mapHolder = new HashMap<>();

    private Singleton() {}

    @SuppressWarnings("unchecked")
    public static <T> T getInstance(Class<T> classOf) {
        synchronized(instance){
            if(!instance.mapHolder.containsKey(classOf)){
                T obj = null;
                try {
                    obj = classOf.newInstance();
                    instance.mapHolder.put(classOf, obj);
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
            return (T)instance.mapHolder.get(classOf);
        }

    }

    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
