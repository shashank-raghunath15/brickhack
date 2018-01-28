package com.brickhack.brokemenu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brickhack.brokemenu.model.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long>{

	List<Recipe> findByUserId(long id);

}
