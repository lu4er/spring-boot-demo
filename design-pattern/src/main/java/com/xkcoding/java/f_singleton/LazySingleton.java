package com.xkcoding.java.f_singleton;

//懒汉式是典型的时间换空间
public class LazySingleton {
    private static LazySingleton instance = null;

    /**
     * 私有默认构造子
     */
    private LazySingleton() {
    }

    /**
     * 静态工厂方法
     */
    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}