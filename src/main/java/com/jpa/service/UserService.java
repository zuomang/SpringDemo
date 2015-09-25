package com.jpa.service;

import com.jpa.domain.User;
import com.jpa.dto.UserDto;

/**
 * Created by Mang on 9/10/15.
 */
public interface UserService {
    void RegisterUser(User user);
    int CheckByName(String name);
    User LoginByName(UserDto user);
}
