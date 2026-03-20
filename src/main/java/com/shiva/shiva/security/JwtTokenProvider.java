package com.shiva.shiva.security;

import java.security.Key;
import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

//import com.sun.org.apache.xml.internal.security.algorithms.SignatureAlgorithm;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenProvider {

    private final String SECRET = "JWTSecretKeyJWTSecretKeyJWTSecretKey"; // >=32 chars

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }

    public String generateToken(Authentication authentication) {

        String email = authentication.getName();

        Date currentDate = new Date();
        Date expireDate = new Date(currentDate.getTime() + 600000); // 10 min

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(currentDate)
                .setExpiration(expireDate)
                .signWith(getSigningKey())   // ✅ NO deprecated
                .compact();
    }

    public String getEmailFromToken(String token) {

        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
               // .signWith(SignatureAlgorithm.HS512, "JWTSecretKey")
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

	
		// TODO Auto-generated method stub
		public boolean validateToken(String token) {
		    try {
		        Jwts.parserBuilder()
		                .setSigningKey(getSigningKey())
		                .build()
		                .parseClaimsJws(token);
		        return true;
		    } catch (Exception e) {
		        return false;
		    }
		}
	
}



