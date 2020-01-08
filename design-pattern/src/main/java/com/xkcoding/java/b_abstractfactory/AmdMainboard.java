package com.xkcoding.java.b_abstractfactory;

/**
 * @Description
 * @Author jerry
 * @CreateTime 2020/01/08 14:13
 */
public class AmdMainboard implements Mainboard {
    private int cpuHoles = 0;

    public AmdMainboard(int cpuHoles) {
        this.cpuHoles = cpuHoles;
    }

    @Override
    public void installCpu() {
        System.out.println("AMD主板的CPU插槽孔数是：" + cpuHoles);
    }
}
