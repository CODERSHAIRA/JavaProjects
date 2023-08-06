package com.kashish.project.authentication.management.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kashish.project.authentication.management.model.AuthenticationRequest;
import com.kashish.project.authentication.management.model.AuthenticationResponse;
import com.kashish.project.authentication.management.model.UserInfo;
import com.kashish.project.authentication.management.service.impl.UserServiceImpl;
import com.kashish.project.authentication.management.utils.JwtUtil;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class UserController {

	private final AuthenticationManager authenticationManager;
	
	private final UserServiceImpl userService;
	
    private final JwtUtil jwtUtil;

	@PostMapping(value = "/registration")
	public ResponseEntity<String> registerUser(@RequestBody UserInfo user) {

		userService.registerUser(user);

		return ResponseEntity.ok().body("User registration successfull!");

	}
	
	@PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }
        UserDetails userDetails = userService.loadUserByUsername(authenticationRequest.getUsername());
        String jwtToken = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwtToken));
    }

}
