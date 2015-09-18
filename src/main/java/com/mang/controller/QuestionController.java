package com.mang.controller;

import com.jpa.domain.QuestionLibrary;
import com.jpa.service.QuestionLibraryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mang on 15/9/18.
 */
@Controller
@RequestMapping(value = "/question")
public class QuestionController {

    final static Logger log = LoggerFactory.getLogger(QuestionController.class);

    @Autowired
    QuestionLibraryService questionLibraryService;

    @RequestMapping(value = "/choice", method = RequestMethod.GET)
    public ModelAndView showChoicePage(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("choice");
        List<QuestionLibrary> libraries = questionLibraryService.getAllQuestionLibrary();
        modelAndView.addObject("librarys", libraries);

        return modelAndView;
    }
}
