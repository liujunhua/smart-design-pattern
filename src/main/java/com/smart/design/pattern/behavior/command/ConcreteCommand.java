package com.smart.design.pattern.behavior.command;

/**
 * @author liujunhua
 * @description: TODO
 * @date 2020/8/268:58
 */
public class ConcreteCommand implements Command {

    private Receiver receiver;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action();
    }
}
