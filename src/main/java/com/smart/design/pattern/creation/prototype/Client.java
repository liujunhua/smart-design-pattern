package com.smart.design.pattern.creation.prototype;

/**
 * @author liujunhua
 * @description: TODO
 * @date 2020/9/911:37
 */
public class Client {
    public static void main(String[] args) {
        User user = new User(1, "liujunhua", new Address("浙江省", "杭州市", "西湖区"));
        User user1 = (User) user.clone();
        System.out.println(user);
        System.out.println(user1);
        System.out.println(user == user1);
        System.out.println(user.getAddress());
        System.out.println(user1.getAddress());
        System.out.println(user.getAddress() == user1.getAddress());
    }
}
