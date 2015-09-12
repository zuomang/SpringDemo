package com.mang.controller;

import com.jpa.dao.UserDao;
import com.jpa.domain.User;
import com.jpa.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mang on 15/9/12.
 */
@Controller
public class RestApiController {

//    @RequestMapping(value = "/register/checkName", method = RequestMethod.POST)
//    public @ResponseBody UserDto checkName(UserDto userDto) {
//        System.out.println(userDto.getName());
//        return userDto;
//    }
    
//    @RequestMapping(value = "/register/checkName", method = RequestMethod.POST)
//    public void checkName(UserDto userDto) {
//        System.out.println(userDto.getName());
//    }

}
