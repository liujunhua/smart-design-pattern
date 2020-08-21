package com.smart.design.pattern.structure.proxy.staticproxy;

/**
 * 被代理对象(目标对象)
 */
public class TargetObject implements IObject {

    @Override
    public void operation() {
        System.out.println("目标对象方法调用");
    }

}
