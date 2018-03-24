/**
 * 
 */
package com.sha.rest_security.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.sha.rest_security.domains.User;
import com.sha.rest_security.dto.SignUpRequest;


@Mapper(componentModel="spring")
public interface UserMapper {
	@Mappings({
		@Mapping(source="userName",target="username"),
		@Mapping(source="password",target="password")
	})
    User signUpToEntity(SignUpRequest signUpReq);

}
