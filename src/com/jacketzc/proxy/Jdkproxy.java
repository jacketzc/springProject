package com.jacketzc.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Jdkproxy implements InvocationHandler {
    private Object target=null;

    public Object bind(Object target){
        this.target=target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理之前。。。。");
        Object obj = method.invoke(target, args);
        System.out.println("代理之后。。。。");
        return obj;
    }
}
