package com.sha.rest_security.filters;

import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.GenericFilterBean;

import com.sha.rest_security.util.CryptographyUtil;
import com.sha.rest_security.util.JwtUtil;

public class JwtAuthenticationFilter extends GenericFilterBean{

	private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String x_token=req.getHeader("x-access-token");
		if(null==x_token || x_token.isEmpty()) {
			((HttpServletResponse) response).setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}else {
			KeyPair keyPair;
			try {
				keyPair = CryptographyUtil.getRSAKey("api_key");
				List<String> permissions=(List<String>)JwtUtil.getClaimFromJwt(keyPair.getPrivate(),x_token,"Permissions");
				logger.info(permissions.toString());
				chain.doFilter(request, response);
			} catch (UnrecoverableKeyException | KeyStoreException | NoSuchAlgorithmException
					| CertificateException e) {
				((HttpServletResponse) response).setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				return;
			}
			
		}

	}

}
