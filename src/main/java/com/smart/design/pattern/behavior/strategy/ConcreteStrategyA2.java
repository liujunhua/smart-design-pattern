package com.smart.design.pattern.behavior.strategy;

/**
 * @author liujunhua
 * @description: TODO
 * @date 2020/9/1111:34
 */
public class ConcreteStrategyA2 implements StrategyA {
    @Override
    public void operate1() {
        System.out.println("ConcreteStrategyA2.operate1()被调用");
    }

    @Override
    public void operate2() {
        System.out.println("ConcreteStrategyA2.operate2()被调用");
    }
}
