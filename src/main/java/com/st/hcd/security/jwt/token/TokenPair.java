package com.st.hcd.security.jwt.token;

import com.st.hcd.entity.Person;

public class TokenPair {

	private JwtToken authToken;
	private JwtToken refreshToken;
	private Person person;
	
	public JwtToken getAuthToken() {
		return authToken;
	}
	public void setAuthToken(JwtToken authToken) {
		this.authToken = authToken;
	}
	public JwtToken getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(JwtToken refreshToken) {
		this.refreshToken = refreshToken;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
}
