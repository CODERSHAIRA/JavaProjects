package com.kashish.project.authentication.management.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kashish.project.authentication.management.model.UserInfo;
import com.kashish.project.authentication.management.service.impl.UserServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class UserController {

	private final UserServiceImpl userService;

	@PostMapping(value = "/registration")
	public ResponseEntity<String> registerUser(@RequestBody UserInfo user) {

		userService.registerUser(user);

		return ResponseEntity.ok().body("User registration successfull!");

	}

}
