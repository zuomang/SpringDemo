package com.mang.controller;

import com.jpa.domain.Choice;
import com.jpa.domain.PracticeLog;
import com.jpa.domain.User;
import com.jpa.dto.RestResponseData;
import com.jpa.dto.UserDto;
import com.jpa.service.ChoiceService;
import com.jpa.service.PracticeLogService;
import com.jpa.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * Created by Mang on 15/9/12.
 */
@RestController
public class RestApiController {

    @Autowired
    UserService userService;

    @Autowired
    ChoiceService choiceService;

    @Autowired
    PracticeLogService practiceLogService;

    static final Logger log= LoggerFactory.getLogger(RestApiController.class);

    @RequestMapping(value = "/register/checkName", method = RequestMethod.POST)
    public @ResponseBody RestResponseData<String> checkName(HttpServletRequest request) {
        String name = request.getParameter("name");
        log.info("check name is unique");

        int count = userService.CheckByName(name);
        return count >= 1 ? new RestResponseData<String>("E0000", "用户名存在") :
                new RestResponseData<String>("E0001", "用户名不存在");
    }

    @RequestMapping(value = "/register/checkEmail", method = RequestMethod.POST)
    public @ResponseBody RestResponseData<String> checkEmail(HttpServletRequest request) {
        String email = request.getParameter("email");
        log.info("check email is unique");

        int count = userService.checkByEmail(email);
        return count >= 1 ? new RestResponseData<String>("E0000", "邮箱存在") :
                new RestResponseData<String>("E0001", "邮箱不存在");
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public @ResponseBody RestResponseData<String> register(User user,
                           HttpSession session) {
        try {
            userService.RegisterUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return new RestResponseData<String>("E0001", "注册失败");
        }
        log.info("new user id is " + user.getId());
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        session.setAttribute("user", userDto);

        return new RestResponseData<String>("E0000", "/home");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody RestResponseData<String> login(UserDto userDto,
                        HttpSession session) {
        log.info("handler login username " + userDto.getName());
        User user = userService.LoginByName(userDto);

        if (user != null) {
            userDto.setId(user.getId());
            session.setAttribute("user", userDto);
            return new RestResponseData<String>("E0000", "/home");
        } else {
            return new RestResponseData<String>("E0001", "账户或用户名错误");
        }
    }

    @RequestMapping(value = "/question/choice/{libraryId}/offset", method = RequestMethod.GET)
    public @ResponseBody Page<Choice> getChoiceById(@PathVariable int libraryId,
                                                    HttpSession session) {
        User user = (User)session.getAttribute("user");
        PracticeLog practiceLog = practiceLogService.findByUserId(user.getId(), libraryId, "choice");

        return choiceService.getChoice(libraryId, practiceLog.getQuestionOffset(), 5);
    }
}
