package com.jpa.service;

import com.jpa.domain.User;
import com.jpa.dto.UserDto;

/**
 * Created by Mang on 9/10/15.
 */
public interface UserService {
    int CheckByName(String name);
    int checkByEmail(String email);

    void RegisterUser(User user);
    User LoginByName(UserDto user);
}