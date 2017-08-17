package com.st.hcd.security.jwt.controller;

import java.util.List;

import io.jsonwebtoken.Claims;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.st.hcd.entity.Person;
import com.st.hcd.security.jwt.config.JwtSettings;
import com.st.hcd.security.jwt.entity.Operator;
import com.st.hcd.security.jwt.service.OperatorService;
import com.st.hcd.security.jwt.token.JwtToken;
import com.st.hcd.security.jwt.token.JwtTokenFactory;
import com.st.hcd.security.jwt.token.TokenPair;
import com.st.hcd.security.jwt.token.TokenType;
import com.st.hcd.security.jwt.token.util.TokenExtractor;
import com.st.hcd.service.PersonService;

@RestController
@RequestMapping("/token")
public class TokenController {

	@Resource
	private PersonService personService;
	
	@Resource
	private OperatorService operatorService;
	
	@Resource
	private JwtTokenFactory jwtTokenFactory;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces={ MediaType.APPLICATION_JSON_VALUE })
	//public TokenPair login(@RequestBody Person login) throws ServletException {
	public TokenPair login(@RequestBody String email) throws ServletException {

		//String email = login.getEmail();
		if ( email == null ) {
			throw new ServletException("Please fill in username and password");
		}

		Person person = personService.getPersonByEmail(email);
		List<Operator> operators = operatorService.findByEmail(email);		

		if (operators == null) {
			throw new ServletException("Operator email not found.");
		}
		
		TokenPair tokenPair = new TokenPair();
		tokenPair.setAuthToken(jwtTokenFactory.createToken(person, operators, TokenType.AUTH));
		tokenPair.setRefreshToken(jwtTokenFactory.createToken(person, operators, TokenType.REFRESH));
		tokenPair.setPerson(person);
		return tokenPair;
	}
	
	@RequestMapping(value = "/refresh", method = RequestMethod.POST, produces={ MediaType.APPLICATION_JSON_VALUE })
	public JwtToken refresh(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		
		String token = request.getHeader(JwtSettings.TOKEN_HEADER_PARAM).replace(JwtSettings.HEADER_PREFIX, "");
		
		Claims claims = TokenExtractor.extractClaims(token);
		
		List<String> scopes = claims.get("scopes", List.class);
        if (scopes == null || scopes.isEmpty() 
                || !scopes.stream().filter(scope -> JwtSettings.REFRESH_TOKEN.equals(scope)).findFirst().isPresent()) {
        	throw new ServletException("Invalid Refresh token");
        }
        
        String email = claims.getSubject();
        
		Person person = personService.getPersonByEmail(email);
		List<Operator> operators = operatorService.findByEmail(email);

		if (operators == null) {
			throw new ServletException("User email not found.");
		}
		return jwtTokenFactory.createToken(person, operators, TokenType.AUTH);
	}
}