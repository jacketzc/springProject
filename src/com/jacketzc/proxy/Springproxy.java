package com.jacketzc.proxy;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

@Component
public class Springproxy implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("拦截之前");
        Object obj = methodInvocation.proceed();
        System.out.println("拦截成功");
        return obj;
    }
}
