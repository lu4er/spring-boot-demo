package com.xkcoding.java.d_builder;

/**
 * @Description
 * @Author jerry
 * @CreateTime 2020/01/08 15:32
 */
public class Client {
    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        director.construct();
        Product product = builder.retrieveResult();
        System.out.println(product.getPart1());
        System.out.println(product.getPart2());
    }
}
