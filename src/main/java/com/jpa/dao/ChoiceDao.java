package com.jpa.dao;

import com.jpa.domain.Choice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by Mang on 15/9/18.
 */
public interface ChoiceDao extends PagingAndSortingRepository<Choice, Integer> {
    Page<Choice> findByLibraryId(int libraryId, Pageable pageable);
}
