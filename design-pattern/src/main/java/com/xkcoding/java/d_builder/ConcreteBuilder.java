package com.xkcoding.java.d_builder;

/**
 * @Description
 * @Author jerry
 * @CreateTime 2020/01/08 15:28
 */
public class ConcreteBuilder implements Builder {
    private Product product = new Product();

    @Override
    public void buildPart1() {
         product.setPart1("编号：9527");
    }

    @Override
    public void buildPart2() {
        product.setPart2("名称：XXX");
    }

    @Override
    public Product retrieveResult() {
        return product;
    }
}
