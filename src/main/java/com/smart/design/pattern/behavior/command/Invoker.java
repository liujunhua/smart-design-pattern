package com.smart.design.pattern.behavior.command;

/**
 * @author liujunhua
 * @description: TODO
 * @date 2020/8/268:59
 */
public class Invoker {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }
}
