package com.brickhack.brokemenu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brickhack.brokemenu.model.Comment;
import com.brickhack.brokemenu.model.Recipe;
import com.brickhack.brokemenu.model.User;

@RestController
public class RecipeController extends Controller{

	@PostMapping("/recipesbyuser")
	public List<Recipe> getRecipiesByUser(@RequestBody User user){
		return getRecipeService().getRecipiesByUser(user);
	}
	
	@GetMapping("recipebyid")
	public Recipe getRecipeByID(@RequestParam long id)
	{
		return getRecipeService().getRecipiesByID(id);
	}
	
	@PostMapping("addRecipe")
	public void addRecipe(@RequestBody Recipe recipe){
		getRecipeService().addRecipe(recipe);
	}
	@GetMapping("getallcomments")
	public List<Comment> getAllComments(@RequestParam long id)
	{
		return getRecipeService().getAllComments(id);
	}
	
	@PostMapping("postcomment")
	public void postComment(@RequestBody Comment comment)
	{
		getRecipeService().addComment(comment);
	}
	
	@GetMapping("addlike")
	public void addLike(@RequestParam long id)
	{
		getRecipeService().addLike(id);
	}
	
	@GetMapping("/getAllRecipes")
	public List<Recipe> getAllRecipes(){
		return getRecipeService().getAll();
	}
}
