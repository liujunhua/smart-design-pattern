package com.smart.design.pattern.creation.factory.simple.example.pizza;

import lombok.Setter;

/**
 * @author liujunhua
 * @description: Pizza
 * @date 2020/12/259:02
 */
@Setter
public abstract class Pizza {

    protected String name;

    public abstract void prepare();

    public void bake() {
        System.out.println(name + " baking;");
    }

    public void cut() {
        System.out.println(name + " cutting;");
    }

    public void box() {
        System.out.println(name + " boxing;");
    }

}