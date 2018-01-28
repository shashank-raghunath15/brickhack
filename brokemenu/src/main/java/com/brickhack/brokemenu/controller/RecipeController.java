package com.brickhack.brokemenu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brickhack.brokemenu.model.Comment;
import com.brickhack.brokemenu.model.Recipe;
import com.brickhack.brokemenu.model.User;

@RestController
public class RecipeController extends Controller {

	@PostMapping("/recipesbyuser")
	public List<Recipe> getRecipiesByUser(@RequestBody User user) {
		return getRecipeService().getRecipiesByUser(user);
	}

	@GetMapping("/recipebyid/{id}")
	public Recipe getRecipeByID(@PathVariable long id) {
		return getRecipeService().getRecipiesByID(id);
	}

	@PostMapping("/addRecipe")
	public void addRecipe(@RequestBody Recipe recipe) {
		getRecipeService().addRecipe(recipe);
	}

	@GetMapping("getallcomments/{id}")
	public List<Comment> getAllComments(@PathVariable long id) {
		return getRecipeService().getAllComments(id);
	}

	@PostMapping("/comment")
	public void postComment(@RequestBody Comment comment) {
		getRecipeService().addComment(comment);
	}

	@PutMapping("/like/{id}")
	public void addLike(@PathVariable long id) {
		getRecipeService().addLike(id);
	}

	@GetMapping("/getAllRecipes")
	public List<Recipe> getAllRecipes() {
		return getRecipeService().getAll();
	}
}
