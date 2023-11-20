package com.cg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.LoginData;
import com.cg.jwt.JwtUtil;

@RestController
public class HelloController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private UserDetailsService userDetailsService; // autowire DummyUserDetailsService

	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to JWT application";
	}


	@PostMapping("/authenticate")
	public ResponseEntity<String> authenticateUser(@RequestBody LoginData loginData) throws Exception {

		try {
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginData.getUsername(), loginData.getPassword()));
			String name = authentication.getName();

			String token = jwtUtil.createToken(loginData);

			return ResponseEntity.ok(token);

		} catch (BadCredentialsException e) {
			return new ResponseEntity<String>("Invalid username or password", HttpStatus.BAD_REQUEST);
		} catch (Exception e) {

			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

}
