package com.xkcoding.java.g_adapter.h;

/**
 * @Description 对象适配器
 * @Author jerry
 * @CreateTime 2020/01/09 09:31
 */
public class Adapter {
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    public void doSomething1() {
        this.adaptee.doSomething1();
    }

    public void doSomething2() {

    }
}
