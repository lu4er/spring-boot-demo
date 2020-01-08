package com.xkcoding.java.b_abstractfactory;

/**
 * @Description
 * @Author jerry
 * @CreateTime 2020/01/08 14:10
 */
public class IntelCpu implements Cpu {

    private int pins = 0;

    public IntelCpu(int pins) {
        this.pins = pins;
    }

    @Override
    public void calculate() {
        System.out.println("Intel Cpu的针脚数：" + pins);
    }
}
