package com.mang.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Mang on 15/9/7.
 */
@Controller
public class HomeController {

    final static Logger log = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(value = {"/", "/home", "/index"}, method = RequestMethod.GET)
    public String ShowHomePage(HttpServletRequest request, HttpServletResponse response) {
        return "index";
    }
}
