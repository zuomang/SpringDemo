package com.jpa.service.impl;

import com.jpa.dao.QuestionLibraryDao;
import com.jpa.domain.QuestionLibrary;
import com.jpa.service.QuestionLibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mang on 15/9/18.
 */
@Service("QuestionLibraryService")
public class QuestionLibraryServiceImpl implements QuestionLibraryService {

    @Autowired
    QuestionLibraryDao questionLibraryDao;

    public List<QuestionLibrary> getAllQuestionLibrary() {
        List<QuestionLibrary> questionLibraries = questionLibraryDao.findAll();
        return questionLibraries;
    }
}
