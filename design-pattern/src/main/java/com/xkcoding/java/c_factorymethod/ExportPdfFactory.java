package com.xkcoding.java.c_factorymethod;

/**
 * @Description
 * @Author jerry
 * @CreateTime 2020/01/08 14:42
 */
public class ExportPdfFactory implements ExportFactory {
    @Override
    public ExportFile factory(String type) {
        if ("standard".equals(type)) {
            return new ExportStandardPdfFile();
        } else if ("financial".equals(type)) {
            return new ExportFinancialPdfFile();
        } else {
            throw new RuntimeException("没有找到对象");
        }

    }
}
