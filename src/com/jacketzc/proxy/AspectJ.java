package com.jacketzc.proxy;

import org.springframework.stereotype.Repository;

@Repository
public class AspectJ {
    public void before(){
        System.out.println("前置切入");
    }
}
