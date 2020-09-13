package com.smart.design.pattern.creation.factory.simple;

public class Client {
    public static void main(String[] args) {

        Product product = (Product) ProductFactory.GetProduct("B");//工厂类创建对象
        product.commonMethod();
        product.specialMethod();
    }
}
