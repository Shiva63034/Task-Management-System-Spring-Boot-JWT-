package com.shiva.shiva.controller;
import com.shiva.shiva.payload.JWTAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shiva.shiva.entity.LoginDto;
import com.shiva.shiva.payload.UserDto;
import com.shiva.shiva.security.JwtTokenProvider;
import com.shiva.shiva.service.UserService;
import com.shiva.shiva.payload.JWTAuthentication;
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	private UserService userService;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	//Post Store in user DB
@PostMapping("/register")
public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
	return new ResponseEntity<>(userService.createUser(userDto),HttpStatus.CREATED);
}
@PostMapping("/login")
	public ResponseEntity<JWTAuthentication > loginUser(@RequestBody LoginDto loginDto ){
		Authentication authentication=
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginDto.getEmail(),loginDto.getPassword())
				);
		System.out.println(authentication);
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		//get the token
		String token=jwtTokenProvider.generateToken(authentication);
	
		return ResponseEntity.ok(new JWTAuthentication(token));
	}
}

