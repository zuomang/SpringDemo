package com.jpa.service.impl;

import com.jpa.dao.PracticeLogDao;
import com.jpa.domain.PracticeLog;
import com.jpa.domain.QuestionLibrary;
import com.jpa.service.PracticeLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Mang on 15/9/24.
 */
@Service("PracticeLogService")
public class PracticeLogServiceImpl implements PracticeLogService{
    @Autowired
    PracticeLogDao practiceLogDao;

    public PracticeLog findByUserId(int userId, int libraryId, String practiceType) {
        PracticeLog practiceLog = practiceLogDao.findByUserIdAndLibraryIdAndPracticeType(userId, libraryId, practiceType);
        if (practiceLog == null) {
            PracticeLog temp = new PracticeLog();
            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());
            temp.setUpdateTime(timestamp);
            temp.setCreateTime(timestamp);
            temp.setQuestionOffset(0);
            temp.setPracticeType(practiceType);
            temp.setLibraryId(libraryId);
            temp.setUserId(userId);
            practiceLogDao.save(temp);
            practiceLog = temp;
        }
        return practiceLog;
    }
}
