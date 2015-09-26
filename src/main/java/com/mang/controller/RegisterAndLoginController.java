package com.mang.controller;

import com.jpa.domain.User;
import com.jpa.dto.UserDto;
import com.jpa.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class RegisterAndLoginController {
    static final Logger log= LoggerFactory.getLogger(RegisterAndLoginController.class);

    @Autowired
    UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String ShowRegisterPage() {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String AddRegister(User user, HttpSession session) {
        userService.RegisterUser(user);
        session.setAttribute("user", user);
        return "redirect:/index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String ShowLoginPage(HttpServletRequest request) {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(UserDto userDto,
                        HttpServletRequest request,
                        HttpSession session) {
        log.info("handler login username " + userDto.getName());
        User user = userService.LoginByName(userDto);
        if (user != null) {
            log.info("password valid success");
            session.setAttribute("user", user);
            if (!request.getHeader("Referer").contains("login")) {
                String temp = request.getHeader("Referer").substring(21);
                return "redirect:" + temp;
            }
        } else {
            log.info("passwrod valid fail");
            return "redirect:/login";
        }
        return "redirect:/index";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        User user = (User)session.getAttribute("user");
        log.info("user " + user.getName() + "logout");
        session.invalidate();
        return "redirect:/index";
    }
}