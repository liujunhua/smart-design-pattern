package com.smart.design.pattern.creation.factory.simple;

public class Client {
    public static void main(String[] args) {
        Product product = ProductFactory.create("A");//工厂类创建对象
        product.commonOperate();
        product.specialOperate();
    }
}
