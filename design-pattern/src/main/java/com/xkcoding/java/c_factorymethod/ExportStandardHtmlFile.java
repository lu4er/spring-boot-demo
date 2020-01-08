package com.xkcoding.java.c_factorymethod;

/**
 * @Description
 * @Author jerry
 * @CreateTime 2020/01/08 14:43
 */
public class ExportStandardHtmlFile implements ExportFile {
    @Override
    public boolean export(String type) {
        System.out.println("导出标准版HTML文件");
        return true;
    }
}
