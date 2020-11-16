package com.smart.design.pattern.structure.proxy.dynamicproxy.cglib;

/**
 * 被代理对象(目标对象)
 */
public class TargetObject {

    public void operation() {
        System.out.println("Cglib代理，目标对象方法调用");
    }

}
