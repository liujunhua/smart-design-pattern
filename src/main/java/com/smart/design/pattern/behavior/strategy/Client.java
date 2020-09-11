package com.smart.design.pattern.behavior.strategy;

/**
 * @author liujunhua
 * @description: TODO
 * @date 2020/9/1111:43
 */
public class Client {
    public static void main(String[] args) {
        Content content = new Content(new ConcreteStrategyA1(), new ConcreteStrategyB1());

        content.ContentOperate1();
        content.ContentOperate2();
    }
}
