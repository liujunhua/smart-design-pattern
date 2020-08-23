package com.smart.design.pattern.creation.factory.simple;

/**
 * 核心部分，负责实现创建所有产品的内部逻辑，工厂类可以被外界直接调用，创建所需对象
 */
public class ProductFactory {
    public static Object GetProduct(String arg) {
        Product product = null;
        if (arg.equals("A")) {
            product = new ConcreteProductA();
        } else if (arg.equals("B")) {
            product = new ConcreteProductB();
        }
        return product;
    }
}
