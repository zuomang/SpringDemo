package com.jpa.service;

import com.jpa.domain.PracticeLog;

/**
 * Created by Mang on 15/9/24.
 */
public interface PracticeLogService {
    PracticeLog findByUserId(int userId, int libraryId, String practiceType);
}
