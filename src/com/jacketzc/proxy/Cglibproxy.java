package com.jacketzc.proxy;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Cglibproxy implements MethodInterceptor {


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("执行代理前");
        Object invoke = methodProxy.invoke(o, objects);
        System.out.println("执行代理后");
        return invoke;
    }
}
