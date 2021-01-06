package com.smart.design.pattern.creation.factory.simple.example.pizza;

/**
 * @author liujunhua
 * @description: CheesePizza
 * @date 2020/12/259:14
 */
public class CheesePizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println(name + " prepare;");
    }
}
