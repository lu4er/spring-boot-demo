package com.xkcoding.java.c_factorymethod;

/**
 * @Description
 * @Author jerry
 * @CreateTime 2020/01/08 14:39
 */
public interface ExportFactory {
    public ExportFile factory(String type);
}
