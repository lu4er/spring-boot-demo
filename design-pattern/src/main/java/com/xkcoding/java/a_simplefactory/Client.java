package com.xkcoding.java.a_simplefactory;

public class Client {
    public static void main(String[] args) {
        ComputerEngineer cf = new ComputerEngineer();
        cf.makeComputer(1, 2);
    }
}