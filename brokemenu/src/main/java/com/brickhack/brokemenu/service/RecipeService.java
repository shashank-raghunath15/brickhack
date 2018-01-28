package com.brickhack.brokemenu.service;

import java.util.List;

import com.brickhack.brokemenu.model.Comment;
import com.brickhack.brokemenu.model.Recipe;
import com.brickhack.brokemenu.model.User;

public interface RecipeService {

	List<Recipe> getRecipiesByUser(User user);

	Recipe getRecipiesByID(long id);

	List<Comment> getAllComments(long id);

	void addComment(Comment comment);

	void addLike(long id);

	void addRecipe(Recipe recipe);

}
