package com.jpa.service.impl;

import com.jpa.dao.ChoiceDao;
import com.jpa.domain.Choice;
import com.jpa.service.ChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mang on 15/9/18.
 */
@Service("ChoiceService")
public class ChoiceServiceImpl implements ChoiceService {
    @Autowired
    ChoiceDao choiceDao;

    public Page<Choice> getChoice(int libraryid, int start, int step) {
        Page<Choice> choices = choiceDao.findByLibraryId(libraryid, new PageRequest(start, step));
        return choices;
    }
}
