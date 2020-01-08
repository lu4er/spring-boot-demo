package com.xkcoding.java.b_abstractfactory;

/**
 * @Description
 * @Author jerry
 * @CreateTime 2020/01/08 14:27
 */
public interface AbstractFactory {
    public Cpu createCpu();

    public Mainboard createMainboard();
}
