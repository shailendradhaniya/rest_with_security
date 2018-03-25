package com.sha.rest_security.util;

import java.security.Key;
import java.time.Period;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;

import org.json.JSONArray;
import org.springframework.security.core.GrantedAuthority;

import com.sha.rest_security.bean.MyUserPrincipal;
import com.sha.rest_security.domains.Role;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {
	//Sample method to construct a JWT
	public static String createJWT(Key key,MyUserPrincipal userPrincipal) {
		JSONArray userPermissions=new JSONArray();
		JSONArray userRoles=new JSONArray();
		for(GrantedAuthority authority:userPrincipal.getAuthorities()) {
			userPermissions.put(authority.getAuthority());
		}
		for(Role role:userPrincipal.getRoles()) {
			userRoles.put(role.getAuthority());
		}
		String jwt = Jwts.builder()
				  .setIssuer("rest-security")
				  .setSubject(userPrincipal.getUsername())
				  .claim("Permissions",userPermissions)
				  .claim("Roles",userRoles)
				  // Fri Jun 24 2016 15:33:42 GMT-0400 (EDT)
				  .setIssuedAt(Date.from(ZonedDateTime.now(ZoneOffset.UTC).toInstant()))
				  // Sat Jun 24 2116 15:33:42 GMT-0400 (EDT)
				  .setExpiration(Date.from(ZonedDateTime.now(ZoneOffset.UTC).plus(Period.ofMonths(6)).toInstant()))
				  .signWith(SignatureAlgorithm.RS256,key)
				  .compact();
		return jwt;
		}
	
	public static Object getClaimFromJwt(Key key,String jwtTokenString,String claimName) {
		Claims claims=Jwts.parser().setSigningKey(key).parseClaimsJws(jwtTokenString).getBody();
		return claims.get(claimName);
	}
}
