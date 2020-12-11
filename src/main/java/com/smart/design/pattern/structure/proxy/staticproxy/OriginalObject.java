package com.smart.design.pattern.structure.proxy.staticproxy;

/**
 * 被代理对象(原始对象)
 */
public class OriginalObject implements IObject {

    @Override
    public void operation() {
        System.out.println("原始对象方法调用");
    }

}
