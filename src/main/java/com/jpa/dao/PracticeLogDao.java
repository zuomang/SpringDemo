package com.jpa.dao;

import com.jpa.domain.PracticeLog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

/**
 * Created by Mang on 15/9/24.
 */
//public interface PracticeLogDao extends Repository<PracticeLog, Integer> {
//
//    @Query(value = "select * from T_EXERCISE_PRACTICE_LOG where USER_ID = ?1 and LIBRARY_ID = ?2 and PRACTICE_TYPE = ?3", nativeQuery = true)
//    PracticeLog findByUserId(int userId, int libraryId, String practiceType);
//}
public interface PracticeLogDao extends BaseDao<PracticeLog, Integer> {

    PracticeLog findByUserIdAndLibraryIdAndPracticeType(int userId, int libraryId, String practiceType);
}
