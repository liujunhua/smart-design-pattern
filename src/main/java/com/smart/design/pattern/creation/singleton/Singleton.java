package com.smart.design.pattern.creation.singleton;

/**
 * 单例设计模式，即某个类在整个系统中只能有一个实例对象可被获取和使用的模式。
 * <p>
 * 8种方式
 * 1. 饿汉式（静态常量）,推荐使用
 * 2. 饿治式（静态代码块）,推荐使用
 * 3. 饿汉式（枚举）,推荐使用
 * 4. 懒汉式（线程不安全）
 * 5. 懒汉式（线程安全，同步方法）
 * 6. 懒汉式（线程安全，同步代码块）
 * 7. 懒汉式（线程安全，双重检查），推荐使用
 * 8. 懒汉式（静态内部类）,推荐使用
 */
public class Singleton {
    public static void main(String[] args) {

        /*System.out.println("1. 饿汉式（静态常量）测试");
        Singleton01 instance1 = Singleton01.getInstance();
        Singleton01 instance2 = Singleton01.getInstance();
        System.out.println(instance1 == instance2);
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());*/

        /*System.out.println("2. 饿治式（静态代码块）测试");
        Singleton02 instance3 = Singleton02.getInstance();
        Singleton02 instance4 = Singleton02.getInstance();
        System.out.println(instance3 == instance4);
        System.out.println(instance3.hashCode());
        System.out.println(instance4.hashCode());*/

        /*System.out.println("3. 饿汉式（枚举）测试");
        Singleton03 instance15 = Singleton03.INSTANCE;
        Singleton03 instance16 = Singleton03.INSTANCE;
        System.out.println(instance15 == instance16);
        System.out.println(instance15.hashCode());
        System.out.println(instance16.hashCode());
        instance15.method();*/

    }

}

/**
 * 1. 饿汉式（静态常量）
 * 直接创建实例对象，不管你是否需要这个对象
 *
 * <p>
 * 步骤如下：
 * 1. 构造器私有化
 * 2. 类内部自行创建创建对象，并且用静态变量保存
 * 3. 向外提供这个实例，
 * 1. 直接暴露，静态公共变量
 * 2. 用静态变量的get方法（静态公共方法）获取，getInstance()
 * <p>
 * 注：强调这是一个单例，我们可以用final修改
 *
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

    // 2. 类内部自行创建创建对象，并且用静态变量保存
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
 * 这种单例模式可用，可能造成内存浪费
 * 适合复杂实例化
 */
class Singleton02 {

    // 1. 构造器私有化
    private Singleton02() {
    }

    // 2. 类内部创建对象,在静态代码块中创建
    private static Singleton02 instance;

    static {
        // 读取初始化数据才能实例化对象的场景
        // 实例化前读取配置信息等
        /*Properties properties=new Properties();
        try {
            properties.load(Singleton02.class.getClassLoader().getResourceAsStream("single.properties"));
        } catch (IOException e) {
           throw new RuntimeException(e);
        }*/
        instance = new Singleton02();
    }

    // 3. 向外暴露一个静态公共方法：getInstance()
    public static Singleton02 getInstance() {
        return instance;
    }

}

/**
 * 3. 饿汉式（枚举）
 * 借助JDK1.5中添加的枚举来实现单例模式，不仅能避免多线程同步问题，而且还能防止反序列化重新创建新的对象
 * <p>
 * 枚举类型，表示该类型的对象是有限的几个，我们可以限定为一个，就成了单例
 * <p>
 * 推荐使用
 */
enum Singleton03 {
    INSTANCE;

    public void method() {
        System.out.println("饿汉式（枚举），方法调用");
    }
}

/**
 * 4. 懒汉式（线程不安全）
 */
class Singleton04 {

    private Singleton04() {
    }

    private static Singleton04 instance;

    /**
     * 懒汉式：延迟创建这个实例对象
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
    public static Singleton04 getInstance() {
        if (instance == null) {
            instance = new Singleton04();
        }
        return instance;
    }

}

/**
 * 5. 懒汉式（线程安全，同步方法）
 */
class Singleton05 {
    private Singleton05() {
    }

    private static Singleton05 instance;

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
    public static synchronized Singleton05 getInstance() {
        if (instance == null) {
            instance = new Singleton05();
        }
        return instance;
    }
}

/**
 * 6. 懒汉式（线程安全，同步代码块）
 * <p>
 * 1. 这种方式，本意是想对 4. 懒汉式（线程安全，同步方法）方式的改进，因为前面同步方法效率太低，
 * 改为同步产生实例化的代码块
 * <p>
 * 2. 但是这种同步并不能起到线程同步的作用。
 * <p>
 * 结棍：
 * 在实际开发中，不能使用这种方式
 */
class Singleton06 {
    private Singleton06() {
    }

    private static Singleton06 instance;

    public static Singleton06 getInstance() {
        if (instance == null) { // 其实线程不安全
            synchronized (Singleton06.class) {
                instance = new Singleton06();
            }
        }
        return instance;
    }
}

/**
 * 懒汉式（线程安全，双重检查）
 *
 * 1. Double-Check概念是多线程开发中常用到的，如果代码中所示，我们进行了两次if(singleton==null)检查，这样就可以保证线程安全了。
 * 2. 这样，实例化代码只用执行一次，后面再访问时，判断if(singleton==null),直接return实例化对象也避免了进行方法反复同步
 * 3. 线程安全 延迟加载 效率较高
 *
 * <p>
 * 解决线程安全问题
 * 解决效率问题
 *
 * 推荐使用
 */
class Singleton07 {
    private Singleton07() {
    }

    private static volatile Singleton07 instance;

    // 提供一个静态的公有方法，加入了双重检查代码，解决线程安全问题，同时解决赖加载问题
    // 同时保证了效率，推荐使用
    public static Singleton07 getInstance() {
        if (instance == null) {//提高效率
            synchronized (Singleton07.class) {
                if (instance == null) {
                    instance = new Singleton07();
                }
            }
        }
        return instance;
    }
}

/**
 * 8. 懒汉式（静态内部类）
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
 * 2. 静态内部类方式在Singleton08类装载时并不会立即实例化，而是在需要实例化时，调用getInstance方法，才会装载SingleInstance类，从而完成Singleton08的实例化
 * 3. 类的静态属性只会在第一次加载类的时候初始化，所以在这里，JVM帮助我们保证了线程的安全性，在类进行初始化时，别的线程是无法进入的
 * 4。优点：避免了线程不安全，利用静态内部类特点实现延迟加载，效率高
 *
 * 推荐使用
 *
 */
class Singleton08 {

    private Singleton08() {
    }

    private static class SingleInstance {
        private static final Singleton08 INSTANCE = new Singleton08();
    }

    public static Singleton08 getInstance() {
        return SingleInstance.INSTANCE;
    }
}