package com.smart.design.pattern.behavior.strategy;

/**
 * @author liujunhua
 * @description: TODO
 * @date 2020/9/1111:33
 */
public class  ConcreteStrategyA1 implements StrategyA {
    @Override
    public void operate1() {
        System.out.println("ConcreteStrategyA1.operate1()被调用");
    }

    @Override
    public void operate2() {
        System.out.println("ConcreteStrategyA1.operate1()被调用");
    }
}
