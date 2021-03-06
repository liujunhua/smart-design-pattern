package com.smart.design.pattern.creation.singleton;

/**
 *
 * @author liujunhua
 * @date 2020/11/16 10:30
 *
 * 3. 饿汉式（枚举）
 * 借助JDK1.5中添加的枚举来实现单例模式，不仅能避免多线程同步问题，而且还能防止反序列化重新创建新的对象
 * <p>
 * 枚举类型，表示该类型的对象是有限的几个，我们可以限定为一个，就成了单例
 * <p>
 * 推荐使用
 *
 */
public enum SingletonByEnum {

    INSTANCE;

    public void method() {
        System.out.println("饿汉式（枚举），方法调用");
    }

    public static void main(String[] args) {
        System.out.println("饿汉式（枚举）测试");
        SingletonByEnum instance1 = SingletonByEnum.INSTANCE;
        SingletonByEnum instance2 = SingletonByEnum.INSTANCE;
        System.out.println(instance1 == instance2);
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
        instance1.method();
    }

}