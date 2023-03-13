package com.benocode.datalayer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.benocode.datalayer.model.Comment;
import com.benocode.datalayer.repository.CommentRepository;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepository commentRepository;
	
	public Iterable<Comment> getComments() {
		return commentRepository.findAll();
	}
	
	public Optional<Comment> getCommentById(Integer id) {
		return commentRepository.findById(id);
	}
}
