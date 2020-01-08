package com.xkcoding.java.c_factorymethod;

public class Client {

    public static void main(String[] args) {
        String data = "";
        ExportFactory exportFactory = new ExportHtmlFactory();
        ExportFile ef = exportFactory.factory("financial");
        ef.export(data);
    }

}
