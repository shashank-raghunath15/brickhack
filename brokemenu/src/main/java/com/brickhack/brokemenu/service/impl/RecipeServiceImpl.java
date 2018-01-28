package com.brickhack.brokemenu.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.brickhack.brokemenu.model.Comment;
import com.brickhack.brokemenu.model.Recipe;
import com.brickhack.brokemenu.model.User;
import com.brickhack.brokemenu.service.RecipeService;

@Service
public class RecipeServiceImpl extends ServiceImpl implements RecipeService{

	@Override
	public List<Recipe> getRecipiesByUser(User user) {
		return getRecipeRepository().findByUserId(user.getId());
	}

	@Override
	public Recipe getRecipiesByID(long id) {
		return getRecipeRepository().findOne(id);
	}

	@Override
	public List<Comment> getAllComments(long id) {		
		return getCommentRepository().findByRecipeId(id);
	}

	@Override
	public void addComment(Comment comment) {
		getCommentRepository().save(comment);
	}

	@Override
	public void addLike(long id) {
		Recipe rec = getRecipiesByID(id);
		rec.setLikeCount(rec.getLikeCount() + 1);
		getRecipeRepository().saveAndFlush(rec);
	}

	@Override
	public void addRecipe(Recipe recipe) {
		// TODO Auto-generated method stub
		getRecipeRepository().save(recipe);
	}

}
