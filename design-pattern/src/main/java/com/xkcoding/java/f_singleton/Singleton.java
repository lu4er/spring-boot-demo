package com.xkcoding.java.f_singleton;

//单元素的枚举类型已经成为实现Singleton的最佳方法。
public enum Singleton {
    /**
     * 定义一个枚举的元素，它就代表了Singleton的一个实例。
     */

    uniqueInstance;

    /**
     * 单例可以有自己的操作
     */
    public void singletonOperation() {
        //功能处理
    }
}
