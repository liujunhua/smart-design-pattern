package com.smart.design.pattern.structure.proxy.dynamicproxy;

import com.smart.design.pattern.structure.proxy.staticproxy.IObject;
import com.smart.design.pattern.structure.proxy.staticproxy.OriginalObject;

/**
 * 客户端
 */
public class Client {

    public static void main(String[] args) {

        // 创建目标对象
        OriginalObject target = new OriginalObject();

        // 注入目标对象，创建代理对象，强转成目标对象接口
        ProxyFactory proxyFactory = new ProxyFactory(target);
        IObject proxyInstance = (IObject) proxyFactory.getProxyInstance();

        // proxyInstance=class com.sun.proxy.$Proxy0 内存中动态生成了代理对象
        System.out.println("proxyInstance=" + proxyInstance.getClass());

        // 通过代理对象调用目标对象方法
        proxyInstance.operation();

    }

}
