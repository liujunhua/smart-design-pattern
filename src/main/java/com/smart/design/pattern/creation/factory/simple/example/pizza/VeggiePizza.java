package com.smart.design.pattern.creation.factory.simple.example.pizza;

/**
 * @author liujunhua
 * @description: VeggiePizza
 * @date 2020/12/259:20
 */
public class VeggiePizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println(name + " prepare;");
    }
}
