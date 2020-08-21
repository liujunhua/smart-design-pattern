package com.smart.design.pattern.structure.proxy.dynamicproxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 *
 */
public class ProxyFactory implements MethodInterceptor {

    // 维护一个被代理对象
    private Object target;

    /**
     * 注入一个被代理对象
     */
    public ProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * 返回一个代理对象：是target的代理对象
     * 1. 创建一个工具类
     * 2. 设置父类
     * 3. 设置回调函数
     * 4. 创建并返回子类对象，即代理对象
     */
    public Object getProxyInstance() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib代理开始");
        Object returnVal = method.invoke(target, args);
        System.out.println("cglib代理结束");
        return returnVal;
    }
}
