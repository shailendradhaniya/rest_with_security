package com.sha.rest_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sha.rest_security.domains.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
