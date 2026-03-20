package com.shiva.shiva.security;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Key;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.util.StringUtils;
import io.jsonwebtoken.Jwts;


@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{
@Autowired
private JwtTokenProvider jwtTokenProvider;
@Autowired
private CustomUserDetailsService customUserDetailsService; 

@Override
protected void doFilterInternal(HttpServletRequest request,
        HttpServletResponse response,
        FilterChain filterChain)
        throws ServletException, IOException {

    try {
        // ✅ Skip auth endpoints
        if (request.getServletPath().contains("/api/auth")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = getToken(request);

        if (token != null && jwtTokenProvider.validateToken(token)) {

            String email = jwtTokenProvider.getEmailFromToken(token);

            UserDetails userDetails =
                    customUserDetailsService.loadUserByUsername(email);

            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(
                            userDetails,
                            null,
                            userDetails.getAuthorities()
                    );

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

    } catch (Exception e) {
        System.out.println("JWT Error: " + e.getMessage());
    }

    // ✅ ALWAYS continue filter chain
    filterChain.doFilter(request, response);
}
	//load the user and serAthentication
		//filterChain.doFilter(request, response);
	

private String getToken(HttpServletRequest request) {
    String bearerToken = request.getHeader("Authorization");

    if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
        return bearerToken.substring(7); // remove "Bearer "
    }

    return null;
}

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
private Key getSigningKey() {
    return Keys.hmacShaKeyFor("JWTSecretKeyJWTSecretKeyJWTSecretKey".getBytes());
}

		
}