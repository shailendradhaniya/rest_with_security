package com.sha.rest_security.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.sha.rest_security.domains.Bookmark;

import java.util.Collection;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    Collection<Bookmark> findByAccountUsername(String username);
}
