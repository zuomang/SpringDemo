package com.mang.controller;

import com.jpa.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class RegisterAndLoginController {
    static final Logger log = LoggerFactory.getLogger(RegisterAndLoginController.class);

    @Autowired
    UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String ShowRegisterPage() {
        return "register";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String ShowLoginPage() {
        return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/index";
    }
}