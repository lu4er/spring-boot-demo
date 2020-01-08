package com.xkcoding.java.a_simplefactory;

/**
 * @Description
 * @Author jerry
 * @CreateTime 2020/01/08 14:15
 */
public class MainboardFactory {
    public static Mainboard createMainboard(int type) {
        Mainboard mainboard = null;
        if (type == 1) {
            mainboard = new IntelMainboard(755);
        } else if (type == 2) {
            mainboard = new AmdMainboard(938);
        }
        return mainboard;
    }
}
