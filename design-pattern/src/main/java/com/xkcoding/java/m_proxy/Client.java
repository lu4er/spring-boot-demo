package com.xkcoding.java.m_proxy;

public class Client {

    public static void main(String[] args) {
        AbstractObject obj = new ProxyObject();
        obj.operation();
    }

}