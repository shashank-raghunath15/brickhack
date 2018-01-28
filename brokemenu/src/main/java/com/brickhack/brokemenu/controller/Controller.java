package com.brickhack.brokemenu.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.brickhack.brokemenu.service.CommentService;
import com.brickhack.brokemenu.service.RecipeService;
import com.brickhack.brokemenu.service.UserService;

public class Controller {

	@Autowired
	private UserService userService;

	@Autowired
	private CommentService commentService;
	
	@Autowired
	private RecipeService recipeService;
	
	public UserService getUserService() {
		return userService;
	}

	public CommentService getCommentService() {
		return commentService;
	}

	public RecipeService getRecipeService() {
		return recipeService;
	}
	
	
	
}
