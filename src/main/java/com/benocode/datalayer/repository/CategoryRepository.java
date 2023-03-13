package com.benocode.datalayer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.benocode.datalayer.model.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer>{

}
