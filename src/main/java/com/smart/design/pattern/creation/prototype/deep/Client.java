package com.smart.design.pattern.creation.prototype.deep;

import com.smart.design.pattern.creation.prototype.Address;

/**
 * @author liujunhua
 * @description: TODO
 * @date 2020/9/915:41
 */
public class Client {
    public static void main(String[] args) {
        User user = new User(1, "liujunhua", new Address("浙江省", "杭州市", "西湖区"));

        System.out.println("---方式1 通过clone方式重写实现---");
        User user1 = (User) user.clone();
        System.out.println(user);
        System.out.println(user1);
        System.out.println(user == user1);
        System.out.println(user.getAddress());
        System.out.println(user1.getAddress());
        System.out.println(user.getAddress() == user1.getAddress());

        System.out.println("---方式2 通过对象的序列化实现---");
        User user2 = (User) user.deepClone();
        System.out.println(user);
        System.out.println(user2);
        System.out.println(user == user2);
        System.out.println(user.getAddress());
        System.out.println(user2.getAddress());
        System.out.println(user.getAddress() == user2.getAddress());
    }
}
