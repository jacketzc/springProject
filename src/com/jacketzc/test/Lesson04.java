package com.jacketzc.test;

import com.jacketzc.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Lesson04 {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("beans8.xml");
        AccountService service = (AccountService) context.getBean("service");
        service.transer("jacketzc","xiaoming",10);
    }
    @Test
    public void test1(){
        ApplicationContext context=new ClassPathXmlApplicationContext("beans8.xml");
        AccountService service = (AccountService) context.getBean("service");
        service.transer("jacketzc","xiaoming",10);
    }
}
