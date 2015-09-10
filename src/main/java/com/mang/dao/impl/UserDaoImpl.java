package com.mang.dao.impl;

import com.mang.dao.UserDao;
import com.mang.domain.UserDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by Mang on 15/9/1.
 */
@Repository("UserDao")
public class UserDaoImpl implements UserDao{
    private final String SQL_INSERT_USER = "insert into user (id, name, email, password) values (?, ?, ?, ?)";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void addUser(UserDomain userDomain) {
        getJdbcTemplate().update(SQL_INSERT_USER, userDomain.getId(), userDomain.getName(), userDomain.getEmail(),
                userDomain.getPassword());
    }
}