package com.xkcoding.java.b_abstractfactory;

/**
 * @Description
 * @Author jerry
 * @CreateTime 2020/01/08 14:13
 */
public class IntelMainboard implements Mainboard {
    private int cpuHoles = 0;

    public IntelMainboard(int cpuHoles) {
        this.cpuHoles = cpuHoles;
    }

    @Override
    public void installCpu() {
        System.out.println("Intel主板的CPU插槽孔数是：" + cpuHoles);
    }
}
