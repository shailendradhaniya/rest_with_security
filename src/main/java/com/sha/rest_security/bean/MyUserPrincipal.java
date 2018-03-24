package com.sha.rest_security.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.sha.rest_security.domains.Permission;
import com.sha.rest_security.domains.Role;
import com.sha.rest_security.domains.RolePermission;
import com.sha.rest_security.domains.User;

public class MyUserPrincipal implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3777860419023394399L;
	private User user;

	public MyUserPrincipal(User user) {
		super();
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<Permission> userPermissions=new ArrayList<>();
	 if(null!=user.getUserRoles()) {
		 
		 user.getUserRoles().forEach(ur -> {
			List<RolePermission> rolePermissions =ur.getRole().getRolePermissions();
			rolePermissions.forEach(p -> {
				userPermissions.add(p.getPermission());
			});
		 }); 
	 }
		return userPermissions;
	}
	
	public Set<Role> getRoles(){
		Set<Role> userRoles=new HashSet<>();
		if(null!=user.getUserRoles()) {
			 user.getUserRoles().forEach(ur -> {
				userRoles.add(ur.getRole());
			 }); 
		 }
		return userRoles;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return user.getEnabled();
	}

	@Override
	public boolean isAccountNonLocked() {
		return user.getEnabled();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return user.getEnabled();
	}

	@Override
	public boolean isEnabled() {
		return user.getEnabled();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
