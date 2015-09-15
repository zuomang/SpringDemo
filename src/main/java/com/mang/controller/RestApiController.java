package com.mang.controller;

import com.jpa.dto.RestResponseData;
import com.jpa.dto.UserDto;
import com.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Mang on 15/9/12.
 */
@RestController
public class RestApiController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/register/checkName", method = RequestMethod.GET)
    public @ResponseBody UserDto GetName(@RequestParam String name) {
        System.out.println(name);
        UserDto userDto = new UserDto();
        userDto.setName(name);
        return userDto;
    }

    @RequestMapping(value = "/register/checkName", method = RequestMethod.POST)
    public @ResponseBody RestResponseData<String> checkName(HttpServletRequest request) {
        String name = request.getParameter("name");
        if (StringUtils.isEmpty(name)) {
            return new RestResponseData<String>("E0010", "用户名为空");
        } else {
            int count = userService.CheckByName(name);
            return count == 1 ? new RestResponseData<String>("E0000", "用户名存在") :
                    new RestResponseData<String>("E0001", "用户名未注册");
        }
    }

//    @RequestMapping(value = "/register/checkName", method = RequestMethod.POST)
//    public @ResponseBody RestResponseData<String> checkName(@RequestBody String data) {
//        ObjectMapper objectMapper = new ObjectMapper();
//        UserDto userDto = new UserDto();
//        try {
//            userDto = objectMapper.readValue(data, UserDto.class);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        int count = userService.CheckByName(userDto.getName());
//        return count == 1 ? new RestResponseData<String>("E0000", "用户名存在") :
//                new RestResponseData<String>("E0001", "用户名未注册");
//    }
}
