package com.mang.controller;

import com.mang.dao.UserDao;
import com.mang.domain.UserDomain;
import com.mang.dto.RegisterDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterAndLoginController {
    static final Logger log= LoggerFactory.getLogger(RegisterAndLoginController.class);

    @Autowired
    UserDao userDao;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String ShowRegisterPage() {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String AddRegister(RegisterDao registerDao) {
        UserDomain userDomain = new UserDomain();
        userDomain.setId(2);
        userDomain.setName(registerDao.getUsername());
        userDomain.setEmail(registerDao.getEmail());
        userDomain.setPassword(registerDao.getPassword());
        log.info(userDomain.getName());

        try {
            userDao.addUser(userDomain);
        } catch (Exception e) {
            log.error("the user table add user error");
            e.printStackTrace();
        } finally {
            log.info("add user success");
        }
        return "register";
    }
}

//    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    public String AddRegister(HttpServletRequest request, HttpServletResponse response) {
//        String username = request.getParameter("username");
//        return "test";
//    }