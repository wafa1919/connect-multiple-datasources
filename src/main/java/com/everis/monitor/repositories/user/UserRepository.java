package com.everis.monitor.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.everis.monitor.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	public User findByUsername(String username);
}
