package com.benocode.datalayer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.benocode.datalayer.model.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer>{
	
	public Iterable<Comment> findByContentContaining(String word);
}
