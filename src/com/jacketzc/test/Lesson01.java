package com.jacketzc.test;

import com.jacketzc.control.UserControl;
import com.jacketzc.dao.UserDao;
import com.jacketzc.dao.UserDaoImpl;
import com.jacketzc.model.User;
import com.jacketzc.proxy.Cglibproxy;
import com.jacketzc.proxy.Jdkproxy;
import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Method;

public class Lesson01 {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("beans1.xml");
        User user = context.getBean(User.class);
        User user1 = (User) context.getBean("user");
        System.out.println(user);
        System.out.println(user1);
    }
    @Test
    public void test1(){
        ApplicationContext context=new ClassPathXmlApplicationContext("beans1.xml");
        UserControl control = context.getBean(UserControl.class);
        control.add();
    }
    @Test
    public void test2(){
        Jdkproxy proxy = new Jdkproxy();
//        UserDao userDao = new UserDaoImpl();
        UserDao dao = (UserDao) proxy.bind(new UserDaoImpl());
        dao.add();
    }
    @Test
    public void test3(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserDaoImpl.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("执行代理前");
                Object invoke = methodProxy.invokeSuper(o, objects);
                System.out.println("执行代理后");
                return invoke;
            }
        });
        UserDaoImpl userDao = (UserDaoImpl) enhancer.create();
        userDao.add();
    }
}
