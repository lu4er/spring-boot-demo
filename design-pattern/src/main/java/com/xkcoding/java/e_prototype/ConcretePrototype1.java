package com.xkcoding.java.e_prototype;

public class ConcretePrototype1 implements Prototype {
    @Override
    public Prototype clone() {
        //最简单的克隆，新建一个自身对象，由于没有属性就不再复制值了
        return new ConcretePrototype1();
    }
}