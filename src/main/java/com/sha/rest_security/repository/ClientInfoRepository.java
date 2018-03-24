package com.sha.rest_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sha.rest_security.domains.ClientInfo;

public interface ClientInfoRepository extends JpaRepository<ClientInfo, String> {

	ClientInfo findByUserId(String id);
}
