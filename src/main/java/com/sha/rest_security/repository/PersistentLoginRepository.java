package com.sha.rest_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sha.rest_security.domains.PersistentLogin;

public interface PersistentLoginRepository extends JpaRepository<PersistentLogin, String> {
}
