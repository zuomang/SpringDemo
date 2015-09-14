package com.jpa.service;

import com.jpa.domain.User;
import com.jpa.dto.UserDto;

/**
 * Created by Mang on 9/10/15.
 */
public interface UserService {
    public void RegisterUser(User user);
    public int CheckByName(String name);
    public boolean LoginByName(UserDto user);
}
