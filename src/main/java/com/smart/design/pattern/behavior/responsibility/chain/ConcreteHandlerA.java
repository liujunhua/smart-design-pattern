package com.smart.design.pattern.behavior.responsibility.chain;

/**
 * @author liujunhua
 * @description: TODO
 * @date 2020/12/1515:24
 */
public class ConcreteHandlerA extends Handler {

    @Override
    public void handlerRequest(Request request) {
        if (request.getQuantity() >= 0 && request.getQuantity() < 10) {
            System.out.println(String.format("%s处理请求%s", this.getClass().getName(), request.getQuantity()));
        } else if (successor != null) {
            successor.handlerRequest(request);
        }
    }

}
