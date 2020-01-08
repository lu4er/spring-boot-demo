package com.xkcoding.java.d_builder;

/**
 * @Description
 * @Author jerry
 * @CreateTime 2020/01/08 15:31
 */
public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct() {
        builder.buildPart1();
        builder.buildPart2();
    }
}
