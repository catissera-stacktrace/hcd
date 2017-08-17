package com.st.hcd.security.jwt.token;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.st.hcd.entity.Person;
import com.st.hcd.security.jwt.config.JwtSettings;
import com.st.hcd.security.jwt.entity.Operator;
import com.st.hcd.security.jwt.entity.Rol;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenFactory {
	
	@Resource
	private JwtSettings jwtSettings;
	
	public JwtToken createToken(Person person, List<Operator> operators , TokenType tokenType) {
		
		Claims claims = Jwts.claims().setSubject(person.getEmail());

		if (tokenType == TokenType.AUTH) {
			for (Operator operator : operators) {
				//operator.getOperatorroles();
				claims.put("scopes", operator.getRoles().stream().map(s -> s.toString()).collect(Collectors.toList()));
			}
			//claims.put("scopes", operators.getRoles().stream().map(s -> s.toString()).collect(Collectors.toList()));
		} else {
			List<String> scopes = new ArrayList<String>();
			scopes.add(JwtSettings.REFRESH_TOKEN);
			claims.put("scopes", scopes);
		}
		
		LocalDateTime currentTime = LocalDateTime.now();
        
		long tokenExpirationTime = (tokenType == TokenType.AUTH)?jwtSettings.getTokenExpirationTime():jwtSettings.getRefreshTokenExpTime();
		
        String token = Jwts.builder()
          .setClaims(claims)
          .setIssuer(jwtSettings.getTokenIssuer())
          .setIssuedAt(Date.from(currentTime.atZone(ZoneId.systemDefault()).toInstant()))
          .setExpiration(Date.from(currentTime
              .plusMinutes(tokenExpirationTime)
              .atZone(ZoneId.systemDefault()).toInstant()))
          .signWith(SignatureAlgorithm.HS512, JwtSettings.SIGNING_KEY)
        .compact();
		
        return new JwtToken(token, claims);
	}

}
