package com.jpa.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * Created by Mang on 9/10/15.
 */
@NoRepositoryBean
public interface BaseDao<T, ID extends Serializable> extends CrudRepository<T, ID> {
}
