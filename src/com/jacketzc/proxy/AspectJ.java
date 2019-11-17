package com.jacketzc.proxy;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectJ {
    /*声明一个公共的切入点*/
    @Pointcut("execution(* com.jacketzc.*.*.*(..))")
    public void pointcut(){}

    @Before("pointcut()")
    public void before(JoinPoint joinPoint){
        System.out.println("前置通知"+joinPoint);
    }
    public void after(){
        System.out.println("最终通知");
    }
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕通知"+pjp);
        Object proceed = pjp.proceed();
        System.out.println("环绕通知");
        return proceed;
    }
    @AfterReturning(pointcut = "execution(* com.jacketzc.*.*.*(..))",returning = "obj")
    public void afterRun(Object obj){
        System.out.println("后置通知"+obj);
    }
    public void afterThrow(JoinPoint joinPoint,Throwable e){
        System.out.println("异常通知"+joinPoint);
    }
}
