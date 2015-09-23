package com.jpa.service;

import com.jpa.domain.Choice;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by Mang on 15/9/18.
 */
public interface ChoiceService {
    public Page<Choice> getChoice(int libraryId, int start, int step);
}
