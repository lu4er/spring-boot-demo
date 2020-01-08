package com.xkcoding.java.d_builder.e;

public class Client {

    public static void main(String[] args) {
        Builder builder = new WelcomeBuilder();
        Director director = new Director(builder);
        director.construct("toAddress@126.com", "fromAddress@126.com");

    }

}