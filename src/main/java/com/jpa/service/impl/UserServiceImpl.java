package com.jpa.service.impl;

import com.common.util.StringHandle;
import com.jpa.dao.UserDao;
import com.jpa.domain.User;
import com.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Mang on 9/10/15.
 */
@Service("UserService")
public class UserServiceImpl implements UserService{

    @Autowired
    UserDao userDao;

    public void RegisterUser(User user) {
        user.setPassword(StringHandle.MD5Hashing(user.getPassword()));
        userDao.save(user);
    }
}
