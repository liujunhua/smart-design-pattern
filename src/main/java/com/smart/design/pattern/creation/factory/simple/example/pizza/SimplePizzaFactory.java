package com.smart.design.pattern.creation.factory.simple.example.pizza;

/**
 * @author liujunhua
 * @description: SimplePizzaFactory
 * @date 2020/12/259:22
 */
public class SimplePizzaFactory {
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals("cheese")) {
            pizza = new CheesePizza();
        } else if (type.equals("veggie")) {
            pizza = new VeggiePizza();
        }
        return pizza;
    }
}
