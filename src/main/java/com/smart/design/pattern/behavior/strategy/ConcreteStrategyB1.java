package com.smart.design.pattern.behavior.strategy;

/**
 * @author liujunhua
 * @description: TODO
 * @date 2020/9/1111:35
 */
public class ConcreteStrategyB1 implements StrategyB {
    @Override
    public void operate1() {
        System.out.println("ConcreteStrategyB1.operate1()被调用");
    }

    @Override
    public void operate2() {
        System.out.println("ConcreteStrategyB1.operate2()被调用");
    }
}
