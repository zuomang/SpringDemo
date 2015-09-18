package com.jpa.dao;

import com.jpa.domain.QuestionLibrary;
import java.util.List;

/**
 * Created by Mang on 15/9/18.
 */
public interface QuestionLibraryDao extends BaseDao<QuestionLibrary, Byte> {
    List<QuestionLibrary> findAll();
}
