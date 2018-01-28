package com.brickhack.brokemenu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brickhack.brokemenu.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{

	List<Comment> findByRecipeId(long id);

}
