package com.brickhack.brokemenu.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Recipe {

	@Id
	@GeneratedValue
	private Long id;
	
	private String description;
	
	@ElementCollection
	private List<String> ingredients = new ArrayList<>();
	
	@OneToMany(mappedBy = "comment")
	private List<Comment> comments = new ArrayList<>();

	private long likeCount;
	
	//private List<Long> likes= new ArrayList<Long>();
	
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;
	
	public long getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(long likeCount) {
		this.likeCount = likeCount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}
	
	
}
