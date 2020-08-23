package com.smart.design.pattern.creation.factory.simple;

/**
 * 工厂类所创建的所有对象的父类，封装了产品对象的公共方法，所有的具体产品为其子类对象
 */
public abstract class Product {
    public void commonMethod() {
        System.out.println("公共方法");
    }

    public abstract void specialMethod();
}
