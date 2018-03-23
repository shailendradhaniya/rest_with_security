package com.sha.rest_security.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.sha.rest_security.domains.Account;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByUsername(String username);
}
