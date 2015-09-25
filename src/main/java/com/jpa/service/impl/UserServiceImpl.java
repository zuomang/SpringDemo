package com.jpa.service.impl;

import com.common.util.StringHandle;
import com.jpa.dao.UserDao;
import com.jpa.domain.User;
import com.jpa.dto.UserDto;
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

    public int CheckByName(String name) {
        int count = userDao.countByName(name);
        return count;
    }

    public void RegisterUser(User user) {
        user.setPassword(StringHandle.MD5Hashing(user.getPassword()));
        userDao.save(user);
    }

    public User LoginByName(UserDto userDto) {
        User user = userDao.findByName(userDto.getName());
        String userPasswrod = StringHandle.MD5Hashing(userDto.getPassword());
        if (userPasswrod.equals(user.getPassword()))
            return user;
        else
            return null;
    }
}
