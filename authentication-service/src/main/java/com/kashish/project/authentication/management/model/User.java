package com.kashish.project.authentication.management.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
	
	private String username;

    private String password;

    private String email;

}
