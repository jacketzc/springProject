package com.jacketzc.dao;

import com.jacketzc.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends JdbcDaoSupport implements UserDao {
/*    private JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }*/

    @Override
    public void add(User user) {
        JdbcTemplate template = super.getJdbcTemplate();
        template.update("insert into t_user (username,password,id) values (?,?,?)",user.getUsername(),user.getPassword(),user.getId());

        System.out.println("添加了一个用户");
    }
}
