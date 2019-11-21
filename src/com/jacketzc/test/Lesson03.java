package com.jacketzc.test;

import com.jacketzc.dao.UserDao;
import com.jacketzc.model.User;
import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class Lesson03 {
    public static void main(String[] args) {
        //创建数据源
        BasicDataSource dataSource=new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///day01");
        dataSource.setUsername("jacketzc");
        dataSource.setPassword("");
        //创建数据库操作对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update("update t_user set username =? where id=?","jacketzc","1");
    }
    @Test
    public void test1(){
        ApplicationContext context=new ClassPathXmlApplicationContext("beans6.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");
        User user = new User(3, "xiaoming", "12345");
        userDao.add(user);
    }
    @Test
    public void test2(){
        ApplicationContext context=new ClassPathXmlApplicationContext("beans7.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");
        User user = new User(4, "siqiao", "77777");
        userDao.add(user);
    }
}
