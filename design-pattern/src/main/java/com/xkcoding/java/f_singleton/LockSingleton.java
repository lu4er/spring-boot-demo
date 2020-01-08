package com.xkcoding.java.f_singleton;

//双重检查加锁
public class LockSingleton {
    private volatile static LockSingleton instance = null;

    private LockSingleton() {
    }

    public static LockSingleton getInstance() {
        //先检查实例是否存在，如果不存在才进入下面的同步块
        if (instance == null) {
            //同步块，线程安全的创建实例
            synchronized (LockSingleton.class) {
                //再次检查实例是否存在，如果不存在才真正的创建实例
                if (instance == null) {
                    instance = new LockSingleton();
                }
            }
        }
        return instance;
    }
}