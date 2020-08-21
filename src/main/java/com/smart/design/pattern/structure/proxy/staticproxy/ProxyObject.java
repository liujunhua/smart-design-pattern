package com.smart.design.pattern.structure.proxy.staticproxy;

/**
 * 代理对象，替代被代理对象(目标对象)
 */
public class ProxyObject implements IObject {

    // 目标对象，通过接口来聚合
    private IObject target;

    /**
     * 属性注入
     * @param target
     */
    public void setTarget(IObject target) {
        this.target = target;
    }

    public ProxyObject() {
        // 直接依赖
        this.target = new TargetObject();
    }

    /**
     * 构造方法注入
     * @param target
     */
    public ProxyObject(IObject target) {
        this.target = target;
    }

    @Override
    public void operation() {
        System.out.println("代理对象方法调用开始");
        this.target.operation();
        System.out.println("代理对象方法调用结束");
    }
}
