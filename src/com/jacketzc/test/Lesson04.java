package com.jacketzc.test;

import com.jacketzc.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Lesson04 {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("beans8.xml");
        AccountService service = (AccountService) context.getBean("service");
        service.transfer("jacketzc","xiaoming",10);
    }
    @Test
    public void test1(){
        ApplicationContext context=new ClassPathXmlApplicationContext("beans9.xml");
        AccountService service = (AccountService) context.getBean("service");
        service.transfer("jacketzc","xiaoming",10);
    }
    @Test
    public void test2(){
        ApplicationContext context=new ClassPathXmlApplicationContext("beans10.xml");
        AccountService service = (AccountService) context.getBean("service");
        service.transfer("jacketzc","xiaoming",10);
//        System.out.println(service.getClass());
    }
    @Test
    public void test3(){
        ApplicationContext context=new ClassPathXmlApplicationContext("beans11.xml");
        AccountService service = (AccountService) context.getBean("service");
        service.transfer("jacketzc","xiaoming",10);
    }
}
