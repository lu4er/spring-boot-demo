package com.xkcoding.java.c_factorymethod;

/**
 * @Description
 * @Author jerry
 * @CreateTime 2020/01/08 14:43
 */
public class ExportFinancialPdfFile implements ExportFile {
    @Override
    public boolean export(String type) {
        System.out.println("导出财务版PDF文件");
        return true;
    }
}
