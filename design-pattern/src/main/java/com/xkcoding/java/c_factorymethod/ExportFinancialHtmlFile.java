package com.xkcoding.java.c_factorymethod;

/**
 * @Description
 * @Author jerry
 * @CreateTime 2020/01/08 14:43
 */
public class ExportFinancialHtmlFile implements ExportFile {
    @Override
    public boolean export(String type) {
        System.out.println("导出财务版HTML文件");
        return true;
    }
}
