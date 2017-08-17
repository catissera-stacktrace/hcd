package com.st.hcd.security.jwt.token.util;

import com.st.hcd.security.jwt.config.JwtSettings;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class TokenExtractor {
	
	public static Claims extractClaims(String token) {
		return Jwts.parser().setSigningKey(JwtSettings.SIGNING_KEY).parseClaimsJws(token).getBody();
	}

}
