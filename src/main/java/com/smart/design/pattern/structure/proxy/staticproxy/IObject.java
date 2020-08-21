package com.smart.design.pattern.structure.proxy.staticproxy;

/**
 * 定义了TargetObject和ProxyObject的共同接口，这样在任何使用TargetObject的地方都可以使用ProxyObject
 */
public interface IObject {
    void operation();
}
