package com.brickhack.brokemenu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.brickhack.brokemenu.repository.CommentRepository;
import com.brickhack.brokemenu.repository.RecipeRepository;
import com.brickhack.brokemenu.repository.UserRepository;

public class ServiceImpl {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RecipeRepository recipeRepository;
	
	@Autowired
	private CommentRepository commentRepository;

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public RecipeRepository getRecipeRepository() {
		return recipeRepository;
	}

	public CommentRepository getCommentRepository() {
		return commentRepository;
	}
	
	
	
}
