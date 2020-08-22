package com.smart.design.pattern.creation.singleton;

/**
 * 单例模式，采取一定的方法保证在整个的软件系统中，使某个类只能存在一个对象实例，并且该类只提供一个取得其对象实例的方法（静态方法）
 * 8种方式
 * 1. 饿汉式（静态常量）
 * 2. 饿治式（静态代码块）
 * 3. 懒汉式（线程不安全）
 * 4. 懒汉式（线程安全，同步方法）
 * 5. 懒汉式（线程安全，同步代码块）
 * 6. 双重检查
 * 7. 静态内部类
 * 8. 枚举
 */
public class Singleton {
    public static void main(String[] args) {

        System.out.println("1. 饿汉式（静态常量）测试");
        Singleton01 instance1 = Singleton01.getInstance();
        Singleton01 instance2 = Singleton01.getInstance();
        System.out.println(instance1 == instance2);
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());

        System.out.println("2. 饿治式（静态代码块）测试");
        Singleton02 instance3 = Singleton02.getInstance();
        Singleton02 instance4 = Singleton02.getInstance();
        System.out.println(instance3 == instance4);
        System.out.println(instance3.hashCode());
        System.out.println(instance4.hashCode());
    }

}

/**
 * 1. 饿汉式（静态常量）
 * <p>
 * 步骤如下：
 * 1. 构造器私有化
 * 2. 类内部创建对象
 * 3. 向外暴露一个静态公共方法：getInstance()
 * <p>
 * 优点：
 * 写法简单，在类装载的时候就完成实例化，避免了线程间同步问题。
 * <p>
 * 缺点：
 * 在类装载的时候就完成实例化，没有达到Lazy Loading的效果，如果从始至终未使用这个实例，则会造成内存的浪费
 * <p>
 * 这种方式基于classloader机制避免了多线程同步问题，不过，instance在类装载时就实例化，在单例模式中大多数都是调用getInstance方法，但是导致类装载的原因有很多种，
 * 因此不能确定有其他的方式（或者其他的静态方法）导致类装载，这时候初始化instance就没有达到lazy loading的效果
 * <p>
 * 结论：
 * 这种单例械可用，可能造成内存浪费
 */
class Singleton01 {

    // 1. 构造器私有化
    private Singleton01() {
    }

    // 2. 类内部创建对象
    private final static Singleton01 instance = new Singleton01();

    // 3. 向外暴露一个静态公共方法：getInstance()
    public static Singleton01 getInstance() {
        return instance;
    }

}

/**
 * 2. 饿治式（静态代码块）
 * <p>
 * 这种方式和饿汉式（静态常量）方式其实类似，只不过将类的实例化过程放在了静态代码块中也是在类装载的时候，就执行静态代码块中的代码，初始化类的实例。
 * 优点和缺点跟饿汉式（静态常量）方式是一样的
 * <p>
 * 结论：
 * 这种单例械可用，可能造成内存浪费
 */
class Singleton02 {

    // 1. 构造器私有化
    private Singleton02() {
    }

    // 2. 类内部创建对象,在静态代码块中创建
    private static Singleton02 instance;

    static {
        instance = new Singleton02();
    }

    // 3. 向外暴露一个静态公共方法：getInstance()
    public static Singleton02 getInstance() {
        return instance;
    }
}

/**
 * 3. 懒汉式（线程不安全）
 */
class Singleton03 {

    private Singleton03() {
    }

    private static Singleton03 instance;

    /**
     * 提供一个静态公有方法，当使用到该方法时，才去创建instance,即懒汉式
     * 在调用getInstance才创建单例对象，饿汉式
     * <p>
     * 优缺点说明
     * 起到了Lazy loading的效果，但是只能在单线程下使用
     * 如果在多线程下，一个线程进入了if(instance==null)断送语句块，还未来得及往下运行，另一个线程也通过了这个判断语句，这时便会产生多个实例
     * 所以在多线程环境下不可使用这种方式
     * <p>
     * 结论：
     * 在实际开发中，不要使用这种方式
     *
     * @return
     */
    public static Singleton03 getInstance() {
        if (instance == null) {
            instance = new Singleton03();
        }
        return instance;
    }

}

/**
 * 4. 懒汉式（线程安全，同步方法）
 */
class Singleton04 {
    private Singleton04() {
    }

    private static Singleton04 instance;

    /**
     * 提供一个静态公有方法，加入了同步代码，解决线程不安全问题，当使用到该方法时，才去创建instance,即懒汉式
     * <p>
     * 1. 解决了线程不安全问题
     * 2. 效率太低了，每个线程在想获得类的实例时候，执行getInstance方法都要进行同步。
     * 而其实这个方法只执行一次实例化代码就够了，后面的想获得该实例，直接return就行了，方法进行同步效率太低了
     * <p>
     * 结论：
     * 在实际开发中，不推荐使用这种方式
     *
     * @return
     */
    public static synchronized Singleton04 getInstance() {
        if (instance == null) {
            instance = new Singleton04();
        }
        return instance;
    }
}

/**
 * 5. 懒汉式（线程安全，同步代码块）
 * <p>
 * 1. 这种方式，本意是想对 4. 懒汉式（线程安全，同步方法）方式的改进，因为前面同步方法效率太低，
 * 改为同步产生实例化的代码块
 * <p>
 * 2. 但是这种同步并不能起到线程同步的作用。
 * <p>
 * 结棍：
 * 在实际开发中，不能使用这种方式
 */
class Singleton05 {
    private Singleton05() {
    }

    private static Singleton05 instance;

    public static Singleton05 getInstance() {
        if (instance == null) { // 其实线程不安全
            synchronized (Singleton05.class) {
                instance = new Singleton05();
            }
        }
        return instance;
    }
}

/**
 * 6. 双重检查
 * <p>
 * 解决线程安全问题
 * 解决效率问题
 */
class Singleton06 {
    private Singleton06() {
    }

    private static volatile Singleton06 instance;

    public static Singleton06 getInstance() {
        if (instance == null) {
            synchronized (Singleton06.class) {
                if (instance == null) {
                    instance = new Singleton06();
                }
            }
        }
        return instance;
    }
}

/**
 * 7. 静态内部类
 */
class Singleton07 {
    private Singleton07() {
    }

    private static class SingleInstance {
        private static final Singleton07 INSTANCE = new Singleton07();
    }

    public static Singleton07 getInstance() {
        return SingleInstance.INSTANCE;
    }
}

/**
 * 枚举
 *
 * 结束：
 * 推荐使用
 */
enum Singleton08 {
    INSTANCE;

    public void method() {
        System.out.println("方法调用");
    }
}