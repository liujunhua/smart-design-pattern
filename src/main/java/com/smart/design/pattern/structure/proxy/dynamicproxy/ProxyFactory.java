package com.smart.design.pattern.structure.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 */
public class ProxyFactory {

    // 维护一个目标对象
    private Object target;

    /**
     * 对target进行初始化
     */
    public ProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * 给目标对象，生成一个代理对象
     */
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), (proxy, method, args) -> {
            System.out.println("JDK代理开始");
            // 反射机制调用目标对象方法
            Object returnVal = method.invoke(target, args);
            System.out.println("JDK代理结束");
            return returnVal;
        });
    }

}