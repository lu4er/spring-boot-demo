package com.xkcoding.java.b_abstractfactory;

/**
 * @Description
 * @Author jerry
 * @CreateTime 2020/01/08 14:31
 */
public class AmdFactory implements AbstractFactory {
    @Override
    public Cpu createCpu() {
        return new AmdCpu(938);
    }

    @Override
    public Mainboard createMainboard() {
        return new AmdMainboard(938);
    }
}
