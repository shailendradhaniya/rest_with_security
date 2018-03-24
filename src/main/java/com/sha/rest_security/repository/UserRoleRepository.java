package com.sha.rest_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sha.rest_security.domains.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, String> {
}
