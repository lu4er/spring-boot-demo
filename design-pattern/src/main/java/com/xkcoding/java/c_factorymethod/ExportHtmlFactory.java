package com.xkcoding.java.c_factorymethod;

/**
 * @Description
 * @Author jerry
 * @CreateTime 2020/01/08 14:40
 */
public class ExportHtmlFactory implements ExportFactory {
    @Override
    public ExportFile factory(String type) {
        if ("standard".equals(type)) {
            return new ExportStandardHtmlFile();
        } else if ("financial".equals(type)) {
            return new ExportFinancialHtmlFile();
        } else {
            throw new RuntimeException("没有找到对象");
        }
    }
}
