package com.smart.design.pattern.behavior.command;

/**
 * @author liujunhua
 * @description: TODO
 * @date 2020/8/268:59
 */
public class Client {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command command = new ConcreteCommand(receiver);
        Invoker invoker = new Invoker();
        invoker.setCommand(command);
        invoker.executeCommand();
    }
}
