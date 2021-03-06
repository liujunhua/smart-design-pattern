package com.smart.design.pattern.creation.factory.simple;

/**
 * 简单工厂模式的创建目标，所有被创建的对象都是某个具体类的实例。它要实现抽象产品中声明的抽象方法
 */
public class ConcreteProductA extends Product {

    @Override
    public void specialOperate() {
        System.out.println("specialOperateA 特定方法");
    }

}
