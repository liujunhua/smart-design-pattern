package com.smart.design.pattern.behavior.responsibility.chain;

/**
 * @author liujunhua
 * @description: TODO
 * @date 2020/12/1515:25
 */
public class ConcreteHandlerC extends Handler {

    @Override
    public void handlerRequest(Request request) {
        if (request.getQuantity() >= 20 && request.getQuantity() < 30) {
            System.out.println(String.format("%s处理请求%s", this.getClass().getName(), request.getQuantity()));
        } else if (successor != null) {
            successor.handlerRequest(request);
        }
    }
}
