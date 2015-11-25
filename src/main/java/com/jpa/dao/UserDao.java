package com.jpa.dao;

import com.jpa.domain.User;
import jdk.nashorn.internal.ir.annotations.Ignore;

/**
 * Created by Mang on 9/10/15.
 */
public interface UserDao extends BaseDao<User, Integer> {
    Integer countByName(String name);
    Integer countByEmail(String email);

    User findByName(String name);
}
