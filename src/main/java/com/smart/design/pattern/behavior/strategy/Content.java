package com.smart.design.pattern.behavior.strategy;

/**
 * @author liujunhua
 * @description: TODO
 * @date 2020/9/1111:32
 */
public class Content {

    private StrategyA strategyA;

    private StrategyB strategyB;

    public Content(StrategyA strategyA, StrategyB strategyB) {
        this.strategyA = strategyA;
        this.strategyB = strategyB;
    }

    void ContentOperate1() {
        strategyA.operate1();
        strategyB.operate1();
    }

    void ContentOperate2() {
        strategyA.operate1();
        strategyB.operate2();
    }
}
