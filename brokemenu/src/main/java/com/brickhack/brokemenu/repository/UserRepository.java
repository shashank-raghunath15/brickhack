package com.brickhack.brokemenu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brickhack.brokemenu.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);

}
