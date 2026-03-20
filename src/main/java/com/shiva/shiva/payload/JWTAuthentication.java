package com.shiva.shiva.payload;

public class JWTAuthentication {
private String token;
private String tokenType="Bearer";
public JWTAuthentication(String token) {
    this.token = token;
}
public String getToken() {
	return token;
}

public String getTokenType() {
	return tokenType;
}

}
