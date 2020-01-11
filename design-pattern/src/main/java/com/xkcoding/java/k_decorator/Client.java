package com.xkcoding.java.k_decorator;

/**
 * @Description
 * @Author jerry
 * @CreateTime 2020/01/09 11:05
 */
public class Client {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        Decorator decorator = new ConcreteDecoratorA(component);
        decorator.sampleOperation();
    }
}
