package com.sha.rest_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sha.rest_security.domains.User;

public interface UserRepository extends JpaRepository<User, String> {
	User findByUsername(String username);
}
