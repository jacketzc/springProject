package com.jacketzc.test;

import com.jacketzc.dao.UserDao;
import com.jacketzc.dao.UserDaoImpl;
import com.jacketzc.proxy.Jdkproxy;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Lesson02 {
    public static void main(String[] args) {
        Jdkproxy proxy = new Jdkproxy();
//        UserDao userDao = new UserDaoImpl();
        UserDao dao = (UserDao) proxy.bind(new UserDaoImpl());
        dao.add();
    }
    @Test
    public void test1(){
        ApplicationContext context=new ClassPathXmlApplicationContext("beans2.xml");
        UserDao dao = (UserDao) context.getBean("proxy");
        dao.add();
    }
    @Test
    public void test2(){
        ApplicationContext context=new ClassPathXmlApplicationContext("beans3.xml");
        UserDao dao =  context.getBean(UserDao.class);
        dao.add();
    }
    @Test
    public void test3(){
        ApplicationContext context=new ClassPathXmlApplicationContext("beans4.xml");
        UserDao dao = context.getBean(UserDao.class);
        dao.add();
    }
}
