package com.st.hcd.security.jwt.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureException;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import com.st.hcd.security.jwt.token.util.TokenExtractor;

public class JwtFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		
		String authHeader = request.getHeader(JwtSettings.TOKEN_HEADER_PARAM);
		
		if (authHeader == null || !authHeader.startsWith(JwtSettings.HEADER_PREFIX)) {
			throw new ServletException("Missing or invalid Authorization header");
		}

		String token = authHeader.replace(JwtSettings.HEADER_PREFIX, "");

		try {
			Claims claims = TokenExtractor.extractClaims(token);
			request.setAttribute("claims", claims);
		} catch (final SignatureException e) {
			throw new ServletException("Invalid token");
		}

		chain.doFilter(request, response);
		
	}

}
