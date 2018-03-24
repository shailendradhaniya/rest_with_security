package com.sha.rest_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sha.rest_security.domains.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByRolename(String rolename);
}
