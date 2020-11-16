package com.smart.design.pattern.creation.singleton;

/**
 * @author liujunhua
 * @date 2020/11/1611:01
 *
 * @description: 懒汉式（静态内部类）
 *
 * <p>
 * 在内部类被加载和初始化时，才创建INSTANCE实例对象
 * 静态内部类不会自动随着外部类的加载和初始化而初始化，它是要单独去加载和初始化的。
 * <p>
 * 静态内部类特点：
 * 1. 外部类装载的时候静态内部类不会被装载
 * 2. 用到了静态内部类的时候才装载，装载的时候线程是安全的，不会有线程安全问题
 * <p>
 * 保证懒加载和线程安全
 *
 * 类的装载机制
 *
 * 1. 这种方式采用了类装载机制来保证初始化实例时只有一个线程
 * 2. 静态内部类方式在SingletonByStaticInnerClass类装载时并不会立即实例化，而是在需要实例化时，调用getInstance方法，才会装载SingleInstance类，从而完成SingletonByStaticInnerClass的实例化
 * 3. 类的静态属性只会在第一次加载类的时候初始化，所以在这里，JVM帮助我们保证了线程的安全性，在类进行初始化时，别的线程是无法进入的
 * 4。优点：避免了线程不安全，利用静态内部类特点实现延迟加载，效率高
 *
 * 推荐使用
 *
 */
public class SingletonByStaticInnerClass {

    private SingletonByStaticInnerClass() {
    }

    private static class SingleInstance {
        private static final SingletonByStaticInnerClass INSTANCE = new SingletonByStaticInnerClass();
    }

    public static SingletonByStaticInnerClass getInstance() {
        return SingleInstance.INSTANCE;
    }

}