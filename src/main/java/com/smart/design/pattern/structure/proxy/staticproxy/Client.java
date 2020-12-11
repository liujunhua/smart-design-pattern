package com.smart.design.pattern.structure.proxy.staticproxy;

/**
 * 客户端
 */
public class Client {
    public static void main(String[] args) {

        /*// 代理对象直接依赖被代理对象
        ProxyObject proxy = new ProxyObject();
        proxy.operation();*/

        /*// 被代理对象通过属性注入
        TargetObject target=new TargetObject();
        ProxyObject proxy=new ProxyObject();
        proxy.setTarget(target);
        proxy.operation();*/

        // 被代理对象通过构造方法注入
        task();

    }

    private static void task() {
        OriginalObject originalObject = new OriginalObject();
        ProxyObject proxy = new ProxyObject(originalObject);
        proxy.operation();
    }
}
