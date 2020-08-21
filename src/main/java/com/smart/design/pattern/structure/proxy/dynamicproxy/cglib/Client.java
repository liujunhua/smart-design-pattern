package com.smart.design.pattern.structure.proxy.dynamicproxy.cglib;

/**
 * 客户端
 */
public class Client {

    public static void main(String[] args) {

        // 1. 创建目标对象
        TargetObject target = new TargetObject();

        // 2. 注入目标对象，创建代理对象，强转成目标类型对象
        TargetObject proxyInstance= (TargetObject) new ProxyFactory(target).getProxyInstance();

        // 3. 通过代理对象调用目标对象方法
        proxyInstance.operation();

    }

}
