package com.xkcoding.java.f_singleton;

//饿汉式是典型的空间换时间
public class EagerSingleton {

    private static EagerSingleton instance = new EagerSingleton();

    /**
     * 私有默认构造子
     */
    private EagerSingleton() {
    }

    /**
     * 静态工厂方法
     */
    public static EagerSingleton getInstance() {
        return instance;
    }
}